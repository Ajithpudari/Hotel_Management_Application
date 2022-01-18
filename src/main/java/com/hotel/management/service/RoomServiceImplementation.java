package com.hotel.management.service;

import com.hotel.management.model.Rooms;

import java.util.List;

public class RoomServiceImplementation implements IRoomsService{
    @Override
    public List<Rooms> getAllRooms(int accessId) {
        return null;
    }

    @Override
    public String updateRoomDetails(int accessId, int id, String date, String roomNo, String availability) {
        return null;
    }

    @Override
    public String deleteRoomDetails(int id, int accessId) {
        return null;
    }

    @Override
    public int rooms(int accessId, Rooms rooms) {
        return 0;
    }

    @Override
    public Rooms getRoomById(int id) {
        return null;
    }
}
