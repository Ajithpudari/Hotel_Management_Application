package com.hotel.management.repository;
import com.hotel.management.constants.Constants;
import com.hotel.management.model.Registration;
import com.hotel.management.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
    public int rooms(int accessId,Rooms rooms) {
        String query = Constants.CREATE_ROOMS;
        Registration regAdd = registrationRepository.getOne(accessId);

        if(Objects.equals(regAdd.getRole(),"admin")) {
            template.update(query,accessId);
            return template.update(query,rooms.getId(),rooms.getDate(),rooms.getRoomNo(),rooms.getAvailability());
        }
        else {
            return 0;
        }




    }

    @Override
    public List<Rooms> getAllRooms(int accessId)
    {
        Registration regGet = registrationRepository.getOne(accessId);
        if(Objects.equals(regGet.getRole(),"user")||Objects.equals(regGet.getRole(),"admin")||Objects.equals(regGet.getRole(),"manager")){
        List<Rooms> rooms = template.query("select id, date,roomNo,availability from new_table", (result, rowNum) -> new Rooms(result.getInt("id"),
                result.getString("date"), result.getString("roomNo"),result.getString("availability")));
        return rooms;}

        else return new ArrayList<>();



    }


    @Override
    public String updateRoomDetails(int accessId,int id, String date, int roomNo, String availability) {
        String query= "update new_table set date = ?,roomNo = ?,availability = ? where id = ?";
        Registration regUpdate = registrationRepository.getOne(accessId);

        if(Objects.equals(regUpdate.getRole(),"admin")) {
            template.update(query,id);
            return "Updated Room " + ": " + roomNo;
        }
        else {
            return "you are not an Admin";
        }

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



    public Rooms getRoomById(int id) {
        String query = "SELECT * FROM new_table WHERE ID=?";
        Rooms room = template.queryForObject(query, new Object[]{id}, new
                BeanPropertyRowMapper<>(Rooms.class));

        return room;
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
