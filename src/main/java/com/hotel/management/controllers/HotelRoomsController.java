package com.hotel.management.controllers;

import com.hotel.management.model.Rooms;
import com.hotel.management.repository.IRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class HotelRoomsController {


    @Autowired
    IRoomsRepository roomsRepository;

    @PutMapping("/admin/updateroom")
    public String updateRoom(@RequestParam("id") int id, String date, int roomNo, String availability) {
        roomsRepository.updateRoom(id, date, roomNo, availability);
        return roomNo + " " + "is updated";
    }

    @DeleteMapping("/admin/deleteroom")
    public String deleteRoom(@RequestParam("id") int id) {
        if (roomsRepository.deleteRoom(id) >= 1) {
            return "Room Deleted Successfully";
        } else {
            return "Something went wrong !";
        }
    }

    @GetMapping("getallrooms")
    public List<Rooms> getAllRooms() {
        return roomsRepository.getAllRooms();
    }

   /* @RequestMapping("user/getRoomsByDate/")
    @ResponseBody
    public List<Rooms> getRoomsByDate(@RequestParam("date") String date){
        return roomsRepository.getRoomsByDate(date);
    }*/


}
