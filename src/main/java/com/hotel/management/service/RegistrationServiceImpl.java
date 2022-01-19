package com.hotel.management.service;

import com.hotel.management.Exception.EmptyInputException;
import com.hotel.management.Exception.EntityExistsException;
import com.hotel.management.Exception.EntityNotExistsException;
import com.hotel.management.Exception.NotFoundException;
import com.hotel.management.model.AppResponse;
import com.hotel.management.model.Registration;
import com.hotel.management.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    IRegistrationRepository registrationRepo;

    @Override
    public ResponseEntity<Object> registration(Registration registration) {
        if (registration.getFirstName().length() != 0) {

            Registration registration1 = registrationRepo.getOne(registration.getId());

            if (registration1 == null) {
                int registrationId = registrationRepo.registration(registration);
                if (registrationId == 1) {

                    return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), true, "Register Success"), HttpStatus.OK);
                }
                else {

                   return new ResponseEntity<>(new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, "Not registered because Internal"), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                throw new EntityExistsException("400","User already available");
            }
        }
        throw new EmptyInputException("400", "provide a proper name");
    }


    @Override
    public ResponseEntity<Object> getOne(int id) {
        //   try {

            Registration registration = registrationRepo.getOne(id);
            if (registration != null)
                return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), "Success"), HttpStatus.OK);
            else
                throw new NotFoundException("404","User Not Found");

    }
    //}

    @Override
    public ResponseEntity<Object> delete(int id, int usrId) {

            Registration reg = registrationRepo.getOne(id);
            if (reg == null)
                throw  new NotFoundException("404" , "User Not Found");

            if (Objects.equals(reg.getRole(), "admin") || Objects.equals(reg.getRole(), "manager")) {
                registrationRepo.delete(usrId);
                return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), "User deleted, userId = " + usrId), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new AppResponse(HttpStatus.FORBIDDEN.value(), "You Are Not Authorised to do this action"), HttpStatus.FORBIDDEN);
            }

    }
    @Override
    public ResponseEntity<Object> allUsers(int id) {
            Registration registration = registrationRepo.getOne(id);
            if (Objects.equals(registration.getRole(), "admin") || Objects.equals(registration.getRole(), "manager")) {
                // return registrationRepo.allUsers();
                return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), registrationRepo.allUsers()), HttpStatus.OK);

          } else {return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(), new ArrayList<>()), HttpStatus.NOT_FOUND);
            }
    }


    @Override
    public ResponseEntity<Object> updateUserById(int id, Registration registration) {

        Registration adminDetails = registrationRepo.getOne(id);
        if(registrationRepo.getOne(id) != null){
        if (adminDetails != null && adminDetails.getRole().equals("admin")) {
            int i = registrationRepo.updatebyId(registration);
            if (i == 1) {
                return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), registrationRepo.updatebyId(registration)), HttpStatus.OK);
            }
                return new ResponseEntity<>(new AppResponse(HttpStatus.BAD_REQUEST.value(), "user not updated"), HttpStatus.BAD_REQUEST);
            }
         else {
           throw new NotFoundException("404", "you are not Authorised" );
        }
        // return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(), "Cannot find user with id=" + id), HttpStatus.NOT_FOUND);
    }throw new EntityNotExistsException("422", "Entity Not found in db");

} }
