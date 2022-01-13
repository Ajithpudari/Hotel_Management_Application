package com.hotel.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.management.repository.RoomsRepository;
import com.hotel.management.repository.BookingRepository;
import com.hotel.management.model.Rooms;
import java.util.List;

@RestController
    public class BookingControllers
    {
        @Autowired
        BookingRepository bookingRepo;

        @RequestMapping(value = "/Role")
        @ResponseBody
        public String getRole(@RequestParam("name") String name){
            return bookingRepo.getRole(name);
        }

      @Autowired
        RoomsRepository roomsRepo;

        @RequestMapping("/user/getAllRooms")
        @ResponseBody
       public List<Rooms> getAllRooms(){
            return roomsRepo.getAllRooms();
        }
    }

