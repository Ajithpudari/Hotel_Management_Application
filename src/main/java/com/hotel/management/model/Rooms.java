package com.hotel.management.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class Rooms {

    private long id;
    private String date;
    private int roomNo;
    private String availability;

    public Rooms() {
    }

    public Rooms(long id, String date, int roomNo, String availability) {
        this.id = id;
        this.date = date;
        this.roomNo = roomNo;
        this.availability = availability;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}