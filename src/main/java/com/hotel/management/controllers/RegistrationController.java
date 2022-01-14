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

   /*   @GetMapping("/Registration")
    public ResponseEntity<List<Registration>> getAllTutorials(@RequestParam(required = false) String registration) {
        try {
            List<Registration> tutorials = new ArrayList<Registration>();

            if (registration == null)
                .getall().forEach(tutorials::add);
            else
                RegistrationServiceImpl.findByTitleContaining(title).forEach(tutorials::add);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new (, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PostMapping("/register")
    public String register(@RequestBody Registration registration) {

        Registration registration1 = registrationService.getOne(registration.getId());
        if (registration1 == null) {
            int registrationId = registrationService.registration(registration);
            if (registrationId == 1) {
                return "Registered Successfully....";
            } else
                return "Failure...Internal Server Error";
        } else
            return "User already registered";

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, @RequestParam int userId) {
        {
            return registrationService.delete(id, userId);

        }
    }

    @GetMapping("/alluser")
    List<Registration> getallUser(String registration) {
        return registrationService.allUsers();
    }

    @PutMapping("/updateuser/{id}")
    String updateUserById(@PathVariable("id") int id) {
        return registrationService.updateUserById(id);
    }

}



