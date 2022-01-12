package com.hotel.management.repository;
import com.hotel.management.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomsRepository {

    @Autowired
    JdbcTemplate template;

    /*Getting all Items from table*/
    /*public List<Rooms> getAllItems() {
        List<Rooms> rooms = template.query("select id,")
                template.query("select id, ,category from item", (result, rowNum) -> new Rooms(result.getInt("id"),
                result.getString("name"), result.getString("category")));
        return items;
    }*/

    //get one item
    /*public Rooms getItem(int itemId) {
        String query = "SELECT * FROM item WHERE ID=?";
        Rooms item = template.queryForObject(query, new Object[]{itemId}, new
                BeanPropertyRowMapper<>(Rooms.class));

        return item;
    }*/

    //add room to database
    public int addRoom(int id,String date,int roomNO,String availability) {
        String query = "INSERT INTO new_table VALUES(?,?,?,?)";
        return template.update(query, id,date, roomNO, availability);
    }

    public void updateRoom(int id, String date, int roomNo, String availability) {
        String query= "update new_table set date = ?,roomNo = ?,availability = ? where id = ?";
        template.update(query, date,roomNo,availability,id);
        System.out.println("Updated Room : " +" " +roomNo );
        return;
    }

    public int deleteRoom(int id){
        String query = "delete from new_table where id =?";
        System.out.println("Deleted Room :" +" "+id);
        return template.update(query,id);
    }






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
