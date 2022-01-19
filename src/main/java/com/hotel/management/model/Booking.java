package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Booking {

    public int bId;
    public int userId;
    public String date;
    public int roomId;

    public Booking() {



    }



    public int getBid() {
        return bId;
    }

    public void setBid(int bid) {
        this.bId = bid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date ;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bid=" + bId +
                ", userId=" + userId +
                ", date=" + date +
                ", roomId=" + roomId +
                '}';
    }

    public Booking(int bid, int userId, String date, int roomId) {
        this.bId = bid;
        this.userId = userId;
        this.date = date;
        this.roomId = roomId;
    }
}

