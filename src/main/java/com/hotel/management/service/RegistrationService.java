package com.hotel.management.service;

import com.hotel.management.model.Registration;

import java.util.List;

public interface RegistrationService {

    String registration(Registration registration);

    Registration getOne(int id);

    String delete(int id, int userId);

    List<Registration> allUsers(int id);

    String updateUserById(int id, Registration registration);

}
