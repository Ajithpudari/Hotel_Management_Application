package com.hotel.management.repository;

import com.hotel.management.model.Rooms;

import java.util.List;

public interface IRoomsRepository {



    //update room in database
    void updateRoom(Integer id, String date, int roomNo, String availability);



    //get all rooms in database
     List<Rooms> getAllRooms();

     String deleteRoomDetails(int id,int accessId);

     String updateRoomDetails(int id ,int accessId);






}
