package com.hotel.management.controllers;

import com.hotel.management.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelRoomsController{
    @Autowired
    private RoomsRepository roomsRepository;

    @RequestMapping("/addRoom")
    @ResponseBody
    public String addRoom(@RequestParam("id") int id, @RequestParam("date") String date,
                          @RequestParam("roomNo") int roomNO,@RequestParam("availability") String availability){
        if(roomsRepository.addRoom(id,date,roomNO,availability) >= 1){
            return "Room Added Successfully";
        }
        else{
            return "Something went wrong !";
        }
    }

    @RequestMapping("/updateRoom")
    @ResponseBody
    public String updateRoom(@RequestParam("id") int id,String date,int roomNo,String availability)
    {
        roomsRepository.updateRoom(id,date,roomNo,availability);
        return roomNo +" "+"is updated";
    }

    @RequestMapping("/deleteRoom")
    @ResponseBody
    public String deleteRoom(@RequestParam("id") int id){
        if(roomsRepository.deleteRoom(id) >= 1){
            return "Room Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }

}
