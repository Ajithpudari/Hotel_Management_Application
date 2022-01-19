package com.hotel.management.service;

import com.hotel.management.model.Booking;

import java.util.List;

public interface IBookingService {
      String addBooking(int userId,int roomId);
    //public  List<Booking> bookedList();

    List<Booking> bookedList(int userId);


    String cancelBooking(int userId, int roomId, int bId);

    int deleteBooking(int bId);
}
