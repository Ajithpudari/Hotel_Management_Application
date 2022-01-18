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

    //Admin can add room details
    @PostMapping("/admin/add")
    public int addRoomDetails(@RequestParam("accessId") int accessId,@RequestBody Rooms rooms){
       return roomsRepository.rooms(accessId,rooms);


    }

    //Gives list of all Rooms
    @GetMapping("/getallrooms")
    public List<Rooms> getAllRooms(@RequestParam("accessId") int accessId){
        return roomsRepository.getAllRooms(accessId);
    }

    //Admin can update room details
    @PutMapping("/admin/update")
    public String updateRoomDetails(@RequestParam("accessId") int accessId,@RequestParam("id") int id,String date,String roomNo,String availability)
    {
        return roomsRepository.updateRoomDetails(accessId,id,date,roomNo,availability);
    }

    //Manager is able to  disable room usage
    @DeleteMapping("/manager/disable")
    public String deleteRoomDetails(@RequestParam("id") int id,@RequestParam ("accessId" ) int accessId){
        return roomsRepository.deleteRoomDetails(id,accessId);
    }

    //Get room by id
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