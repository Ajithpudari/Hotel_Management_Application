package com.hotel.management.service;

import com.hotel.management.model.Rooms;

import java.util.List;

public interface IRoomsService {

    List<Rooms> getAllRooms(int accessId);

    String updateRoomDetails(int accessId, int id, String date, String roomNo, String availability);

    String deleteRoomDetails(int id, int accessId);

    String rooms(int accessId, Rooms rooms);

    Rooms getRoomById(int id);
}
