package com.hotel.management.repository;

import com.hotel.management.model.Rooms;

import java.util.List;

public interface IRoomsRepository {

    //add room to database
    public int addRoom(int id,String date,int roomNO,String availability);

    //update room in database
    public void updateRoom(int id, String date, int roomNo, String availability);

    //delete room in database
    public int deleteRoom(int id);

    //get all rooms in database
    public List<Rooms> getAllRooms();

    //get rooms by date
    //public List<Rooms> getRoomsByDate(String date);


}
