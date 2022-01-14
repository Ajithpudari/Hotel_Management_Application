package com.hotel.management.repository;
import com.hotel.management.model.Registration;
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






    @Override
    public void updateRoom(Integer id, String date, int roomNo, String availability) {
        String query= "update new_table set date = ?,roomNo = ?,availability = ? where id = ?";
        template.update(query, date,roomNo,availability,id);
        System.out.println("Updated Room with Id: " +" " +roomNo );
        return;
    }



    @Override
    public List<Rooms> getAllRooms()
    {
        List<Rooms> rooms = template.query("select id, date,roomNo,availability from new_table", (result, rowNum) -> new Rooms(result.getInt("id"),
                result.getString("date"), result.getInt("roomNo"),result.getString("availability")));
        return rooms;
    }


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
/* @Override
    public int deleteRoom(int id){
        String query = "delete from new_table where id =?";
        System.out.println("Deleted Room :" +" "+id);
        return template.update(query,id);
    }*/