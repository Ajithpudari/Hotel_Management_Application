package com.hotel.management.repository;
import com.hotel.management.constants.Constants;
import com.hotel.management.model.Registration;
import com.hotel.management.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RoomsRepository implements IRoomsRepository {

    @Autowired
    JdbcTemplate template;
    @Autowired
    IRegistrationRepository registrationRepository;

    @Override
    public int rooms(int accessId,Rooms rooms)  {
        Registration regAdd = registrationRepository.getOne(accessId);

        try
        {
        if(Objects.equals(regAdd.getRole(),"admin"))
        {
            String query = Constants.CREATE_ROOMS;
            return template.update(query,rooms.getId(),rooms.getDate(),rooms.getRoomNo(),rooms.getAvailability());
        }
        } catch (NullPointerException e) {
            System.out.println("You are not registered");
        }
        return accessId;
    }



    @Override
    public List<Rooms> getAllRooms(int accessId)
    {
        List<Rooms> rooms = template.query("select id, date,roomNo,availability from new_table", (result, rowNum) -> new Rooms(result.getInt("id"),
                result.getString("date"), result.getString("roomNo"),result.getString("availability")));
        return rooms;
    }

    @Override
    public String updateRoomDetails(int accessId,int id, String date, String roomNo, String availability) {

        String query= Constants.UPDATE_ROOMS;
        template.update(query,date,roomNo,availability,id);
        return "Room: "+roomNo+" details updated";
    }


    @Override
    public String deleteRoomDetails(int id,int accessId) {
        String query = Constants.DELETE_ROOMS;
        Registration reg = registrationRepository.getOne(id);
        try {
            if(Objects.equals(reg.getRole(),"manager")){
            template.update(query,accessId);
            return "Deleted Room Details with id :"+accessId;
        }
        else{
            return "You  are not the Manager";
        }
        }
        catch (NullPointerException e)
        {
            return "You are not registered";
        }

    }


    @Override
    public Rooms getRoomById(int id) {
        String query = Constants.SELECT_ROOMS;
        Rooms room = template.queryForObject(query, new Object[]{id}, new
                BeanPropertyRowMapper<>(Rooms.class));

        return room;
    }





}




/* public int addRoom(int id,String date,int roomNO,String availability) {
        String query = "INSERT INTO new_table VALUES(?,?,?,?)";
        return template.update(query,id,date, roomNO, availability);
    }*/

/**/
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
