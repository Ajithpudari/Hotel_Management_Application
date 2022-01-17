package com.hotel.management.repository;

import com.hotel.management.model.Rooms;

import java.util.List;

public interface IRoomsRepository {



    //get all rooms in database
    List<Rooms> getAllRooms(int accessId);

    //update room in database
    void updateRoomDetails(int id, String date, String roomNo, String availability);

    //delete room details based on id
    String deleteRoomDetails(int id, int accessId);

    //add room details
    public int rooms(Rooms rooms);

    //get room by id
    public Rooms getRoomById(int id);



}
