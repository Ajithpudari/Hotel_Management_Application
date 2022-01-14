package com.hotel.management.repository;

import com.hotel.management.model.Rooms;

import java.util.List;

public interface IRoomsRepository {

<<<<<<< HEAD

=======
    //add room to database
    public int addRoom(int id, String date, int roomNO, String availability);
>>>>>>> 43680c93fac675818b48204a32df155a1b14ebe8

    //update room in database


    void updateRoom(Integer id, String date, int roomNo, String availability);

    //delete room in database
     int deleteRoom(int id);

    //get all rooms in database
     List<Rooms> getAllRooms();



     int addRoom(Rooms rooms) ;


    String deleteRoomDetails(int id, int accessId);

    String updateRoomDetails(int id, int accessId);
}
