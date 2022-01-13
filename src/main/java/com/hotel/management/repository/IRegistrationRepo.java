package com.hotel.management.repository;

import com.hotel.management.model.Registration;

import java.util.List;


public interface IRegistrationRepo {
    int registration(Registration registration);
    Registration getOne(int id);
    String delete(int id);
    //public List<Registration> getall();

}