package com.hotel.management.controllers;

import com.hotel.management.model.AppResponse;
import com.hotel.management.model.Registration;
import com.hotel.management.model.Rooms;
import com.hotel.management.repository.IRoomsRepository;
import com.hotel.management.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelRoomsController{


    @Autowired
    IRoomsRepository roomsRepository;

    @PostMapping("/admin/add/room_details")
    public Rooms addRoomDetails(@RequestBody Rooms rooms){
        roomsRepository.rooms(rooms);
        return rooms;

    }


    //Gives list of all Rooms
    @GetMapping("/get_all/room_details")
    public List<Rooms> getAllRooms(@RequestParam("accessId") int accessId){
        return roomsRepository.getAllRooms(accessId);
    }

    //only Admin can update room details
    @PutMapping("/admin/update/room_details")
    public String updateRoomDetails(@RequestParam("id") int id,String date,String roomNo,String availability)
    {
        roomsRepository.updateRoomDetails(id,date,roomNo,availability);
        return "room updated successfully";

    }

    //Only Manager can disable
    @DeleteMapping("manager/disable/room_details")
    public String deleteRoomDetails(@RequestParam("id") int id,@RequestParam ("accessId" ) int accessId){
        return roomsRepository.deleteRoomDetails(id,accessId);
    }

    //get room by id
    @GetMapping("get/{id}")
    public Rooms getById(@PathVariable("id") int id ){
        return roomsRepository.getRoomById(id);
    }

    /*@PutMapping("/update")
    public  String update(@RequestParam("id") int id,@RequestParam ("accessId") int accessId),{

    }*/





 /*@PutMapping("/update")
    public  String update(@RequestParam("id") int id,@RequestParam ("accessId") int accessId),{

    }*/
}
/* @PostMapping("/admin/addRoom")
public String addRoom(@RequestParam("id") int id,@RequestParam("date") String date,
@RequestParam("roomNO") int roomNO,@RequestParam("availability") String availability){
        roomsRepository.addRoom(id,date,roomNO,availability);
        return "Room:"+roomNO +":"+date+" "+"successfully";*/


/* @DeleteMapping("/admin/deleteRoom")
    public String deleteRoom(@RequestParam("id") int id){
        roomsRepository.deleteRoom(id);
            return "Room Deleted Successfully";

    }*/

/*
    @RequestMapping("/addItem")
    @ResponseBody
    public String addItem(@RequestParam("id") int id,@RequestParam("date") String date,@RequestParam("roomNO") int roomNO,
                          @RequestParam("availability") String availability){
        if(itemRepo.addItem(id,date,roomNO,availability) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }*/