package com.hotel.management.repository;

import com.hotel.management.model.Registration;

import java.util.List;

public interface IRegistrationRepository {
    public int save(Registration registration);
    public int update(Registration registration);
    public Registration findById(int id);
    public int deleteById(int id);

    public List<Registration> findAll();
    public List<Registration> findByRole(String  role);
    public int deleteAll();

    int registration(Registration registration);




}
