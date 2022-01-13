package com.hotel.management.service;

import com.hotel.management.model.Registration;
import com.hotel.management.repository.IRegistrationRepository;
import com.hotel.management.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Service
public class RegistrationServiceImple implements RegistrationService {

    @Autowired
    IRegistrationRepository registrationRepo;

    @Override
    public int registration(Registration registration) {
        return registrationRepo.registration(registration);
    }

    @Override
    public Registration getOne(int id) {
        return registrationRepo.getOne(id);
    }

    @Override
    public String delete(int id, int usrId) {
        Registration reg = registrationRepo.getOne(id);
        if (reg == null)
            return "User Not Found";

        if (Objects.equals(reg.getRole(), "admin") || Objects.equals(reg.getRole(), "manager")) {
            registrationRepo.delete(usrId);
            return "deleted";
        } else {
            return "you are not authorised";
        }
    }

    @Override
    public List<Registration> allUsers() {
        List <Registration> reg= registrationRepo.allUsers();
        return reg;
    }

    @Override
    public String updateUserById(int id) {
        Registration registration1 = registrationRepo.getOne(id);
        if (registration1 != null) {
            registration1.setFirstName(registration1.getFirstName());
            registration1.setLastName(registration1.getLastName());
            registration1.setPhoneNumber(registration1.getPhoneNumber());
            registration1.setRole(registration1.getRole());
            registrationRepo.updatebyId(registration1);
            return "user was updated successfully.";
        } else
            return "Cannot find user with id=" + id;
    }

}
