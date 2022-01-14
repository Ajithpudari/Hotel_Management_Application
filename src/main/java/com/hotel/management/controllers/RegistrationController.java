package com.hotel.management.controllers;

import com.hotel.management.model.AppResponse;
import com.hotel.management.model.Registration;
import com.hotel.management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Registration registration) {
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), registrationService.registration(registration)), HttpStatus.OK);

    }

    @GetMapping("/getoneuser/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") int id) {
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), registrationService.getOne(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id, @RequestParam int userId) {
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),  registrationService.delete(id, userId)), HttpStatus.OK);
    }

    @GetMapping("/userlist/{id}")
    public ResponseEntity<Object> getallUser(@PathVariable("id") int id) {
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),  registrationService.allUsers(id)), HttpStatus.OK);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable("id") int id, @RequestBody Registration registration) {
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),  registrationService.updateUserById(id, registration)), HttpStatus.OK);
    }

}



