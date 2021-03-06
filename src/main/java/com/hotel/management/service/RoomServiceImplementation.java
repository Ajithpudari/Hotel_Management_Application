package com.hotel.management.service;

import com.hotel.management.constants.Constants;
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
public class RoomServiceImplementation implements IRoomsService {

    @Autowired
    IRegistrationRepository iRegistrationRepository;

    @Autowired
    IRoomsRepository iRoomsRepository;

    @Override
    public List<Rooms> getAllRooms(int accessId) {
        Registration regGet = iRegistrationRepository.getOne(accessId);
        if (Objects.equals(regGet.getRole(), "user") || Objects.equals(regGet.getRole(), "admin") || Objects.equals(regGet.getRole(), "manager")) {
            return iRoomsRepository.getAllRooms(accessId);
        } else return new ArrayList<>();
    }

    @Override
    public String updateRoomDetails(int accessId, int id, String date, String roomNo, String availability) {
        Registration regUpdate = iRegistrationRepository.getOne(accessId);

        try {
            if (Objects.equals(regUpdate.getRole(), "admin")) {
                return iRoomsRepository.updateRoomDetails(accessId, id, date, roomNo, availability);
            } else return "You are not an Admin";
        } catch (NullPointerException e) {
            return Constants.USER_NOT;
        }
        catch (Exception e){
            return "Something Is Wrong";
        }

    }

    @Override
    public String deleteRoomDetails(int id, int accessId) {
        Registration regDel = iRegistrationRepository.getOne(id);
        try {
            if (Objects.equals(regDel.getRole(), "manager")) {
                return iRoomsRepository.deleteRoomDetails(id, accessId);
            } else {
                return "You  Are Not The Manager";
            }
        } catch (NullPointerException e) {
            return Constants.USER_NOT;
        }
        catch (Exception e){
            return "Something is Wrong";
        }
    }

    @Override
    public int rooms(int accessId, Rooms rooms) {
        Registration regAdd = iRegistrationRepository.getOne(accessId);
        if (Objects.equals(regAdd.getRole(), "admin")) {
            iRoomsRepository.rooms(accessId, rooms);
            return 1;
        } else return 0;

    }

    @Override
    public Rooms getRoomById(int id) {
        return iRoomsRepository.getRoomById(id);
    }
}
