package com.hotel.management.service;
import com.hotel.management.model.Booking;
import com.hotel.management.model.Registration;
import com.hotel.management.model.Rooms;
import com.hotel.management.repository.BookingRepository;
import com.hotel.management.repository.IRegistrationRepository;
import com.hotel.management.repository.IRoomsRepository;
import com.hotel.management.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookingService implements IBookingService {

    @Autowired
    RoomsRepository roomsRepo;

    @Autowired
    IRegistrationRepository iRegistrationRepository;

    @Autowired
    IRoomsRepository iRoomsRepository;

    @Autowired
    BookingRepository bookingRepository;


    @Override
    public String addBooking(int userId, int roomId) {
        Registration reg1 = iRegistrationRepository.getOne(userId);
        Rooms room = iRoomsRepository.getRoomById(roomId);

        if (Objects.equals(reg1.getRole(), "user") && Objects.equals(room.getAvailability(), "Yes")) {
            Booking booking1 = new Booking(userId, userId, room.getDate(), roomId);
            int isBooking = bookingRepository.book(booking1);
            if (isBooking == 1) {
                iRoomsRepository.updateRoomDetails(userId, roomId, room.getDate(), room.getRoomNo(), "No");

            }
            return "Room Booked";

        }else
        return "Room Not Booked";
    }

    @Override
    public List<Booking> bookedList(int userId) {

        Registration registration = iRegistrationRepository.getOne(userId);
        Booking booking1 = bookingRepository.bookedList().get(userId);

        return bookingRepository.bookedList();

    }


    @Override
    public String cancelBooking(int userId, int roomId, int bId)
    {
        Registration regC = iRegistrationRepository.getOne(userId);
        Rooms roomC = iRoomsRepository.getRoomById(roomId);
        Booking bk = bookingRepository.bookedList().get(userId);
        if(Objects.equals(regC.getRole(),"user") && Objects.equals(roomC.getAvailability(),"No"))
        {

                bookingRepository.deleteBooking(bId);
            iRoomsRepository.updateRoomDetails(userId,roomId,roomC.getDate(),roomC.getRoomNo(),"Yes");
        }

        return "Success";
    }

    @Override
    public int deleteBooking ( int bId){
        return bookingRepository.deleteBooking(bId);
    }
}




/*

    @Override
        public List<Booking> allbookedList() {
            {
                Booking booking=bookingRepository.bookedList();
                return bookingRepository.allbookedList();

            }


    }
*/


   /* @Override
    public List<Booking> viewBookedList(userId) {
        Registration reg1= iRegistrationRepository.getOne(userId);
        Rooms room= iRoomsRepository.getAllRooms();

      List<Booking> bookedList =
        return null;
    }*/

