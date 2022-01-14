package com.hotel.management.repository;

import com.hotel.management.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomsRepository implements IRoomsRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public int addRoom(int id, String date, int roomNO, String availability) {
        String query = "INSERT INTO new_table VALUES(?,?,?,?)";
        return template.update(query, id, date, roomNO, availability);
    }

    @Override
    public void updateRoom(int id, String date, int roomNo, String availability) {
        String query = "update new_table set date = ?,roomNo = ?,availability = ? where id = ?";
        template.update(query, date, roomNo, availability, id);
        System.out.println("Updated Room : " + " " + roomNo);
        return;
    }

    @Override
    public int deleteRoom(int id) {
        String query = "delete from new_table where id =?";
        System.out.println("Deleted Room :" + " " + id);
        return template.update(query, id);
    }

    @Override
    public List<Rooms> getAllRooms() {
        List<Rooms> rooms = template.query("select id, date,roomNo,availability from new_table", (result, rowNum) -> new Rooms(result.getInt("id"),
                result.getString("date"), result.getInt("roomNo"), result.getString("availability")));
        return rooms;
    }

   /* @Override
    public List<Rooms> getRoomsByDate(String date) {
        String query = "select * from new_table where date =?";
        List<Rooms> rooms = template.query("select id, date,roomNo,availability from new_table", (result, rowNum) -> new Rooms(result.getInt("id"),
                result.getString("date"), result.getInt("roomNo"),result.getString("availability")));
        return template.queryForList(query,Rooms.class,rooms);
    }*/

    //delete item from database
    /*public int deleteItem(long id){
        String query = "DELETE FROM ITEM WHERE ID =?";
        return template.update(query,id);
    }

    //update item in database
    public void update(Integer id,String name,String category){
        String query= "update item set name = ?,category = ? where id = ?";
        template.update(query, name,category, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }*/


}
