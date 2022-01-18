package com.hotel.management.controllers;

import com.hotel.management.model.AppResponse;
import com.hotel.management.model.Registration;
import com.hotel.management.model.Rooms;
import com.hotel.management.repository.IRoomsRepository;
import com.hotel.management.repository.RoomsRepository;
import com.hotel.management.service.IRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelRoomsController {


    @Autowired
    IRoomsService roomsService;

    //Admin can add room details
    @PostMapping("/admin/add")
    public String addRoomDetails(@RequestParam("accessId") int accessId, @RequestBody Rooms rooms) {
        String i = roomsService.rooms(accessId, rooms);
        if (i != null) {
            return "Room Details Added Successfully";
        }
        else
        {
            return "Room Details Not Added";
        }

    }

    //Gives list of all Rooms
    @GetMapping("/getallrooms")
    public List<Rooms> getAllRooms(@RequestParam("accessId") int accessId) {
        return roomsService.getAllRooms(accessId);
    }

    //Admin can update room details
    @PutMapping("/admin/update")
    public String updateRoomDetails(@RequestParam("accessId") int accessId, @RequestParam("id") int id, String date, String roomNo, String availability) {
        return roomsService.updateRoomDetails(accessId, id, date, roomNo, availability);
    }

    //Manager is able to  disable room usage
    @DeleteMapping("/manager/disable")
    public String deleteRoomDetails(@RequestParam("id") int id, @RequestParam("accessId") int accessId) {
        return roomsService.deleteRoomDetails(id, accessId);
    }

    //Get room by id
    @GetMapping("/get/{id}")
    public String getById(@PathVariable("id") int id) {
        roomsService.getRoomById(id);
        return "Success";
    }

}