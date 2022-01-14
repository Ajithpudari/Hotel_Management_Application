package com.hotel.management.controllers;

import com.hotel.management.model.Rooms;
import com.hotel.management.repository.IRoomsRepository;
import com.hotel.management.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
@RestController
@RequestMapping("/hotel")
public class HotelRoomsController{
=======
public class HotelRoomsController {
>>>>>>> 43680c93fac675818b48204a32df155a1b14ebe8


    @Autowired
    IRoomsRepository roomsRepository;
<<<<<<< HEAD
    RoomsRepository itemRepo;

    //Gives list of all Rooms
    @GetMapping("/get_all/room_details")
    public List<Rooms> getAllRooms(){
=======

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
>>>>>>> 43680c93fac675818b48204a32df155a1b14ebe8
        return roomsRepository.getAllRooms();
    }

    //only Admin can update room details
    @PutMapping("/admin/update/room_details")
    public String updateRoom(@RequestParam("id") int id,String date,int roomNo,String availability)
    {
        roomsRepository.updateRoom(id,date,roomNo,availability);
        return "roomNo"+" "+roomNo +" "+"is updated";
    }

    //Only Manager can disable
    @DeleteMapping("manager/disable/room_details")
    public String delete(@RequestParam("id") int id,@RequestParam ("accessId" ) int accessId){
       return roomsRepository.deleteRoomDetails(id,accessId);
    }

    /*@PutMapping("/update")
    public  String update(@RequestParam("id") int id,@RequestParam ("accessId") int accessId),{

    }*/


<<<<<<< HEAD



 /*@PutMapping("/update")
    public  String update(@RequestParam("id") int id,@RequestParam ("accessId") int accessId),{

    }*/
=======
>>>>>>> 43680c93fac675818b48204a32df155a1b14ebe8
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