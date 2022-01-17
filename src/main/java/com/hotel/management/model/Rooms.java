package com.hotel.management.model;

public class Rooms {

    private int id;
    private String date;
    private String roomNo;
    private String availability;

    public Rooms() {
    }

    public Rooms(int id, String date, String roomNo, String availability) {
        this.id = id;
        this.date = date;
        this.roomNo = roomNo;
        this.availability = availability;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
