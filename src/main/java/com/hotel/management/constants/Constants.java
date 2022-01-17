package com.hotel.management.constants;

public class Constants {
    public static final String SELECT_REG_ROLE = "SELECT role FROM registration WHERE name =?";

    public static final String SELECT_REG = "SELECT * FROM registration WHERE ID=?";
    public static final String DELETE_REG = "DELETE FROM registration WHERE id=?";
    public static final String SELECT_REG_BY_ROLE = "SELECT id, firstName, lastName, phoneNumber ,role FROM registration WHERE role='user'";
    public static final String UPDATE_REG = "UPDATE registration SET firstName=?, lastName=?, phoneNumber=?  WHERE id=?";
    public static final String CREATE_REG = "INSERT INTO registration VALUES(?,?,?,?,?)";

    public static final String CREATE_ROOMS = "INSERT INTO new_table VALUES(?,?,?,?)";
    public static final String UPDATE_ROOMS = "UPDATE new_table SET date=?,roomNo=?,availability=? WHERE id=?";
    public static final String DELETE_ROOMS = "DELETE FROM new_table WHERE id =?";
    public static final String SELECT_ROOMS = "SELECT id, date,roomNo,availability FROM new_table";

}
