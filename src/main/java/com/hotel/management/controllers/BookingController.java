package com.hotel.management.controllers;

import com.hotel.management.model.AppResponse;
import com.hotel.management.model.Rooms;
import com.hotel.management.repository.BookingRepository;
import com.hotel.management.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepo;

    @Autowired
    RoomsRepository roomsRepo;

    @GetMapping(value = "/role")
    public String getRole(@RequestParam("name") String name) {
        return bookingRepo.getRole(name);
    }

   /* @GetMapping("/user/getallrooms")
    public ResponseEntity<Object> getAllRooms() {
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), roomsRepo.getAllRooms()),HttpStatus.OK);
    }*/
}

