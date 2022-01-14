package com.hotel.management.controllers;

import com.hotel.management.model.Rooms;
import com.hotel.management.repository.IRoomsRepository;
import com.hotel.management.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hotel")
public class HotelRoomsController{


    @Autowired
    IRoomsRepository roomsRepository;

    //Gives list of all Rooms
    @GetMapping("/GetAllRoomDetails")
    public List<Rooms> getAllRooms(){
        return roomsRepository.getAllRooms();
    }

    //only Admin can update room details
    @PutMapping("/Admin/UpdateRoomDetails")
    public String updateRoom(@RequestParam("id") int id,String date,int roomNo,String availability)
    {
        roomsRepository.updateRoom(id,date,roomNo,availability);
        return "roomNo"+" "+roomNo +" "+"is updated";
    }

    //Only Manager can disable a room from usage
    @DeleteMapping("/Manager/DisableRoomUsage")
    public String disableRoomUsage(@RequestParam("id") int id,@RequestParam ("accessId" ) int accessId){
       return roomsRepository.deleteRoomDetails(id,accessId);
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