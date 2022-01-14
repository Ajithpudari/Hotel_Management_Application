package com.hotel.management.repository;
<<<<<<< HEAD
import com.hotel.management.model.Registration;
=======

import com.hotel.management.constants.Constants;
>>>>>>> 43680c93fac675818b48204a32df155a1b14ebe8
import com.hotel.management.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class RoomsRepository implements IRoomsRepository {


    @Autowired
    JdbcTemplate template;
    @Autowired
    IRegistrationRepository registrationRepository;

<<<<<<< HEAD





    public int addRoom(Rooms rooms) {
        String query = "INSERT INTO new_table VALUES(?,?,?,?)";
        return template.update(query, rooms.getId(),rooms.getDate(),rooms.getRoomNo(),rooms.getAvailability());
    }

    @Override
    public void updateRoom(Integer id, String date, int roomNo, String availability) {
        String query= "update new_table set date = ?,roomNo = ?,availability = ? where id = ?";
        template.update(query, date,roomNo,availability,id);
        System.out.println("Updated Room with Id: " +" " +roomNo );
=======
    @Override
    public int addRoom(int id, String date, int roomNO, String availability) {
        String query = Constants.CREATE_ROOMS;
        return template.update(query, id, date, roomNO, availability);
    }

    @Override
    public void updateRoom(int id, String date, int roomNo, String availability) {
        String query = Constants.UPDATE_ROOMS;
        template.update(query, date, roomNo, availability, id);
        System.out.println("Updated Room : " + " " + roomNo);
>>>>>>> 43680c93fac675818b48204a32df155a1b14ebe8
        return;
    }

    @Override
    public int deleteRoom(int id) {
        String query = Constants.DELETE_ROOMS;
        System.out.println("Deleted Room :" + " " + id);
        return template.update(query, id);
    }

    @Override
    public List<Rooms> getAllRooms() {
        List<Rooms> rooms = template.query(Constants.SELECT_ROOMS, (result, rowNum) -> new Rooms(result.getInt("id"),
                result.getString("date"), result.getInt("roomNo"), result.getString("availability")));
        return rooms;
    }

<<<<<<< HEAD
=======
   /* @Override
    public List<Rooms> getRoomsByDate(String date) {
        String query = "select * from rooms where date =?";
        List<Rooms> rooms = template.query("select id, date,roomNo,availability from rooms", (result, rowNum) -> new Rooms(result.getInt("id"),
                result.getString("date"), result.getInt("roomNo"),result.getString("availability")));
        return template.queryForList(query,Rooms.class,rooms);
    }*/
>>>>>>> 43680c93fac675818b48204a32df155a1b14ebe8

    @Override
    public String deleteRoomDetails(int id,int accessId) {
        String query = "delete from new_table where id =?";
        Registration reg = registrationRepository.getOne(id);

        if(Objects.equals(reg.getRole(),"manager")){
             template.update(query,accessId);
            return "Deleted Room Details with id :"+accessId;
        }
        else{
            return "You  are not the Manager";
        }
    }

    @Override
    public String updateRoomDetails(int id, int accessId) {
        String query = "update new_table set date = ?,roomNo = ?,availability = ? where id = ?";
        Registration regOne = registrationRepository.getOne(id);

        if (Objects.equals(regOne.getRole(), "admin")) {
            template.update(query, accessId);
            return "Updated Room Details with id :"+accessId;
        } else {
            return "You are not an Admin";
        }


    }






}



/* public int addRoom(int id,String date,int roomNO,String availability) {
        String query = "INSERT INTO new_table VALUES(?,?,?,?)";
        return template.update(query,id,date, roomNO, availability);
    }*/
 /* public String delete(int id, int usrId) {
        Registration reg = registrationRepo.getOne(id);
        if (reg == null)
            return "User Not Found";

        if (Objects.equals(reg.getRole(), "admin") || Objects.equals(reg.getRole(), "manager")) {
            registrationRepo.delete(usrId);
            return "deleted";
        } else {
            return "you are not authorised";
        }*/
