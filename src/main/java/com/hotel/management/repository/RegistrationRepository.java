package com.hotel.management.repository;

import com.hotel.management.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepository implements IRegistrationRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int registration(Registration registration) {
        String query = "INSERT INTO registration VALUES(?,?,?,?,?)";
        try{
        return jdbcTemplate.update(query, registration.getId(),registration.getFirstName(),registration.getLastName(),
                registration.getPhoneNumber(),
                registration.getRole());

        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Registration getOne(int id) {
        String query = "SELECT * FROM registration WHERE ID=?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{id}, new
                    BeanPropertyRowMapper<>(Registration.class));
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String delete(int id) {
        String query="DELETE FROM registration WHERE id=?";
        int deleted=jdbcTemplate.update(query,id);
        if (deleted==1)
            return "success";
        return "Failure";

    }
}
