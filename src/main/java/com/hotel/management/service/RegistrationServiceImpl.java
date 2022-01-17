package com.hotel.management.service;

import com.hotel.management.Exception.BusinessException;
import com.hotel.management.model.AppResponse;
import com.hotel.management.model.Registration;
import com.hotel.management.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    IRegistrationRepository registrationRepo;

    @Override
    public ResponseEntity<Object> registration(Registration registration) {
            try {
            if(registration.getFirstName().isEmpty() || registration.getFirstName().length()== 0) {
                throw new BusinessException("601","please send propername");
            }
                Registration registration1 = registrationRepo.getOne(registration.getId());

                if (registration1 == null) {
                    int registrationId = registrationRepo.registration(registration);
                    if (registrationId == 1) {
                        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), true, "Register Success"), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, "Not registered because Internal"), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                } else {
                    return new ResponseEntity<>(new AppResponse(HttpStatus.BAD_REQUEST.value(), false, "User already registered"), HttpStatus.BAD_REQUEST);
                }
            }catch (IllegalArgumentException e) {
                throw new BusinessException("602","given value is null" + e.getMessage());

            }catch (Exception e ){
                throw new BusinessException("603","somthing went wrong in service layer" +e.getMessage());
            }
    }

    @Override
    public ResponseEntity<Object> getOne(int id) {

        Registration registration=registrationRepo.getOne(id);
        if (registration!=null)
            return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), "Success"), HttpStatus.OK);

        return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(), "User not found"), HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<Object> delete(int id, int usrId) {
        Registration reg = registrationRepo.getOne(id);
        if (reg == null)
            return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(), "Not avalable with the id"), HttpStatus.NOT_FOUND);

        if (Objects.equals(reg.getRole(), "admin") || Objects.equals(reg.getRole(), "manager")) {
            registrationRepo.delete(usrId);
            return  new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), "User deleted, userId = " + usrId), HttpStatus.OK ); }
        else {
            return new ResponseEntity<>(new AppResponse(HttpStatus.FORBIDDEN.value(), "You Are Not Authorised to do this action"), HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public ResponseEntity<Object> allUsers(int id) {
       // try {

            Registration registration = registrationRepo.getOne(id);
            if (Objects.equals(registration.getRole(), "admin") || Objects.equals(registration.getRole(), "manager")) {
                // return registrationRepo.allUsers();
                return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), registrationRepo.allUsers()), HttpStatus.OK);
            } else
                return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(), new ArrayList<>()), HttpStatus.NOT_FOUND);
      //  }catch{

        }


    @Override
    public ResponseEntity<Object> updateUserById(int id, Registration registration) {
        Registration adminDetails = registrationRepo.getOne(id);
        if (adminDetails != null && adminDetails.getRole().equals("admin")) {
            int i = registrationRepo.updatebyId(registration);
            if(i == 1) {
                return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), registrationRepo.updatebyId(registration)), HttpStatus.OK);

            }
            else{
                    return new ResponseEntity<>(new AppResponse(HttpStatus.BAD_REQUEST.value(),"user not updated") , HttpStatus.BAD_REQUEST);

            }
        } else
                return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(),"Cannot find user with id=" + id) , HttpStatus.NOT_FOUND);
    }

}
