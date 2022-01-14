package com.hotel.management.service;

import com.hotel.management.model.Registration;
import com.hotel.management.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
