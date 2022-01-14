package com.hotel.management.service;

import com.hotel.management.model.Registration;
import com.hotel.management.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    IRegistrationRepository registrationRepo;

    @Override
    public String registration(Registration registration) {
        Registration registration1 = registrationRepo.getOne(registration.getId());
        if (registration1 == null) {
            int registrationId = registrationRepo.registration(registration);
            if (registrationId == 1) {
                return ("Registered Successfully, You userId = " + registration.getId());
            } else {
                return "Not Registered";
            }
        } else {
            return "User already registered";
        }
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
            return "User deleted, userId = " + usrId;
        } else {
            return "you are not authorised";
        }
    }

    @Override
    public List<Registration> allUsers(int id) {
        Registration registration = registrationRepo.getOne(id);
        if (Objects.equals(registration.getRole(), "admin") || Objects.equals(registration.getRole(), "manager")) {
            return registrationRepo.allUsers();
        } else return null;
    }

    @Override
    public String updateUserById(int id, Registration registration) {
        Registration adminDetails = registrationRepo.getOne(id);
        if (adminDetails != null && adminDetails.getRole().equals("admin")) {
            int i = registrationRepo.updatebyId(registration);
            return i == 1 ? "user was updated successfully." : "User not updated";
        } else
            return "Cannot find user with id=" + id;
    }

}
