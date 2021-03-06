package com.hotel.management.repository;

import com.hotel.management.model.Booking;
import com.hotel.management.model.Registration;

import java.util.List;

public interface IBookingRepository
{
    public String addBooking(Booking booking);
    List<Booking> bookedList(int userId);
    public String  cancelBooking(Booking booking);
}
