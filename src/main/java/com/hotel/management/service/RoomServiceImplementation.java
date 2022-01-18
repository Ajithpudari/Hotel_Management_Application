package com.hotel.management.service;

import com.hotel.management.model.Registration;
import com.hotel.management.model.Rooms;
import com.hotel.management.repository.IRegistrationRepository;
import com.hotel.management.repository.IRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RoomServiceImplementation implements IRoomsService{

    @Autowired
    IRegistrationRepository reg;

    @Autowired
    IRoomsRepository ro;

    @Override
    public List<Rooms> getAllRooms(int accessId) {
        Registration regGet = reg.getOne(accessId);
        if(Objects.equals(regGet.getRole(),"user")||Objects.equals(regGet.getRole(),"admin")||Objects.equals(regGet.getRole(),"manager"))
        {
            return ro.getAllRooms(accessId);
        }
        else return new ArrayList<>();
    }

    @Override
    public String updateRoomDetails(int accessId, int id, String date, String roomNo, String availability)
    {
        Registration regUpdate = reg.getOne(accessId);

            if(Objects.equals(regUpdate.getRole(),"admin"))
            {
                return ro.updateRoomDetails(accessId,id,date,roomNo,availability);
            }
            else return "You are not an Admin";

    }

    @Override
    public String deleteRoomDetails(int id, int accessId) {
        return null;
    }

    @Override
    public int rooms(int accessId, Rooms rooms) {
        return 0;
    }

    @Override
    public Rooms getRoomById(int id) {
        return null;
    }
}
