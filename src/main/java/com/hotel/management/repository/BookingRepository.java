package com.hotel.management.repository;

import com.hotel.management.constants.Constants;
import com.hotel.management.model.Booking;
import com.hotel.management.model.Registration;
import com.hotel.management.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {



    @Autowired
    JdbcTemplate jdbcTemplate;
    //private String user;//

/*
    public String getRole(String name) {
        String query = Constants.SELECT_REG_ROLE;
        template.update(query, name);
        return "name";
    }
*/
public int addBooking(Booking booking){
    return jdbcTemplate.update(Constants.ADD_BOOK, booking.bId, booking.userId, booking.date, booking.roomId);
}
   public  List<Booking> bookedList(){

    return jdbcTemplate.query(Constants.BOOKED_LIST, (result, rowNum) -> new Booking(result.getInt("bId"),result.getInt("userId"),result.getString("date"),result.getInt("roomId")));
   }
   public int book(Booking booking)
   {
       return jdbcTemplate.update(Constants.BOOKING,booking.getBid(),booking.getUserId(),booking.getDate(),booking.getRoomId());
   }


}


