package com.hotel.management.constants;

public class Constants {
    public static final String SELECT_REG_ROLE = "SELECT role FROM registration WHERE name =?";

    public static final String SELECT_REG = "SELECT * FROM registration WHERE ID=?";
    public static final String DELETE_REG = "DELETE FROM registration WHERE id=?";
    public static final String SELECT_REG_BY_ROLE = "SELECT id, firstName, lastName, phoneNumber ,role FROM registration WHERE role='user'";
    public static final String UPDATE_REG = "UPDATE registration SET firstName=?, lastName=?, phoneNumber=?  WHERE id=?";
    public static final String CREATE_REG = "INSERT INTO registration VALUES(?,?,?,?,?)";

    public static final String CREATE_ROOMS = "INSERT INTO new_table VALUES(?,?,?,?)";
    public static final String UPDATE_ROOMS = "update new_table set date = ?,roomNo = ?,availability = ? where id = ?";
    public static final String DELETE_ROOMS = "delete from new_table where id =?";
    public static final String SELECT_ROOMS = "SELECT * FROM new_table WHERE ID=?";


    public static final String ADD_BOOK = "UPDATE rooms SET date = ? ,availability = ? WHERE id = ?";
    public static final String BOOKED_LIST = "SELECT * FROM booking";
    public static final String BOOKING ="INSERT INTO booking VALUES(?,?,?,?)";
    public static final String CANCEL_BOOK =" DELETE FROM BOOKING WHERE bId = ?";

    public static final String USER_NOT ="User Details Not Found";

}
