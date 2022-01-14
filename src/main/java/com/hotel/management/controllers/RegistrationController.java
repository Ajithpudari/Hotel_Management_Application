package com.hotel.management.controllers;

import com.hotel.management.model.Registration;
import com.hotel.management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody Registration registration) {
        return registrationService.registration(registration);
    }

    @GetMapping("/getoneuser/{id}")
    Registration getOne(@PathVariable("id") int id) {
        return registrationService.getOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, @RequestParam int userId) {
        {
            return registrationService.delete(id, userId);
        }
    }

    @GetMapping("/userlist/{id}")
    public List<Registration> getallUser(@PathVariable("id") int id) {
        return registrationService.allUsers(id);
    }

    @PutMapping("/updateuser/{id}")
    public String updateUserById(@PathVariable("id") int id, @RequestBody Registration registration) {
        return registrationService.updateUserById(id, registration);
    }

}



