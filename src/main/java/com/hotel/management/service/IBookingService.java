package com.hotel.management.service;

import com.hotel.management.model.Booking;
import com.hotel.management.model.Registration;
import com.hotel.management.model.Rooms;

import java.util.List;

public interface IBookingService {
      String addBooking(int userId,int roomId);
    //public  List<Booking> bookedList();

    List<Booking> bookedList(int userId);


}
