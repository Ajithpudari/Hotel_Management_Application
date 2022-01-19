package com.hotel.management.controllers;

import com.hotel.management.model.AppResponse;
import com.hotel.management.model.Booking;
import com.hotel.management.model.Rooms;
import com.hotel.management.repository.BookingRepository;
import com.hotel.management.repository.RoomsRepository;
import com.hotel.management.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    IBookingService iBookingService;

    @PostMapping("/book")
    public String Book(@RequestParam("userId") int userId, @RequestParam("roomId") int roomId) {
        return iBookingService.addBooking(userId , roomId);

    }


    @GetMapping("/bookingList")
    public List <Booking> allBookedList(@RequestParam ("userId") int userId)
    {
        return iBookingService.bookedList(userId);
    }


    @DeleteMapping("/cancelBooking")
    public String cancelBooking(@RequestParam("userId") int userId, @RequestParam("roomId") int roomId,@RequestParam("bId") int bId) {
        return iBookingService.cancelBooking(userId,roomId,bId);

    }




   /* @GetMapping("/user/getallrooms")
    public ResponseEntity<Object> getAllRooms() {
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), roomsRepo.getAllRooms()),HttpStatus.OK);
    }*/
}

