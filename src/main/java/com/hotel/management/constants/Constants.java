package com.hotel.management.constants;

public class Constants {
    public static final String SELECT_REG_ROLE = "select role from registration where name =?";

    public static final String SELECT_REG = "SELECT * FROM registration WHERE ID=?";
    public static final String DELETE_REG = "DELETE FROM registration WHERE id=?";
    public static final String SELECT_REG_BY_ROLE = "select id, firstName, lastName, phoneNumber ,role from registration where role='user'";
    public static final String UPDATE_REG = "UPDATE registration SET firstName=?, lastName=?, phoneNumber=?  WHERE id=?";
    public static final String CREATE_REG = "INSERT INTO registration VALUES(?,?,?,?,?)";

    public static final String CREATE_ROOMS = "INSERT INTO rooms VALUES(?,?,?,?)";
    public static final String UPDATE_ROOMS = "update rooms set date = ?,roomNo = ?,availability = ? where id = ?";
    public static final String DELETE_ROOMS = "delete from rooms where id =?";
    public static final String SELECT_ROOMS = "select id, date,roomNo,availability from rooms";

}
