package com.hotel.management.service;

import com.hotel.management.model.Registration;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RegistrationService {


    ResponseEntity<Object> registration(Registration registration);

    ResponseEntity<Object> getOne(int id);

    public ResponseEntity<Object> delete(int id, int usrId);

    public ResponseEntity<Object> allUsers(int id);

    public ResponseEntity<Object> updateUserById(int id, Registration registration);

}
