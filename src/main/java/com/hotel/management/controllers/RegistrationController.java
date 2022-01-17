package com.hotel.management.controllers;

import com.hotel.management.advice.EntityExistsAlready;
import com.hotel.management.model.AppResponse;
import com.hotel.management.model.Registration;
import com.hotel.management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Registration registration) {
            return registrationService.registration(registration);
    }


        @GetMapping("/getoneuser/{id}")
        public ResponseEntity<Object> getOne ( @PathVariable("id") int id)
        {
      //  try {
            return registrationService.getOne(id);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> delete ( @PathVariable("id") int id, @RequestParam int userId)
        {
            return registrationService.delete(id, userId);
        }

        @GetMapping("/userlist/{id}")
        public ResponseEntity<Object> getallUser ( @PathVariable("id") int id)
        {
        return  registrationService.allUsers(id);

        }

        @PutMapping("/updateuser/{id}")
        public ResponseEntity<Object> updateUserById ( @PathVariable("id") int id,@RequestParam int userId,
        @RequestBody Registration registration)
        {
        return registrationService.updateUserById(id, registration);
        }

    }



