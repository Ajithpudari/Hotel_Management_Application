package com.hotel.management.controllers;

import com.hotel.management.model.Rooms;
import com.hotel.management.repository.BookingRepository;
import com.hotel.management.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/user/getallrooms")
    public List<Rooms> getAllRooms() {
        return roomsRepo.getAllRooms();
    }
}

