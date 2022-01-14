package com.hotel.management.repository;

import com.hotel.management.constants.Constants;
import com.hotel.management.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationRepository implements IRegistrationRepository {



    @Autowired
    JdbcTemplate jdbcTemplate;


    //registration
    @Override
    public int registration(Registration registration) {
        String query = Constants.CREATE_REG;
        try {
            return jdbcTemplate.update(query, registration.getId(), registration.getFirstName(), registration.getLastName(),
                    registration.getPhoneNumber(),
                    registration.getRole());
        } catch (Exception e) {
            return 0;
        }
    }

    // get one user
    @Override
    public Registration getOne(int id) {
        String query = Constants.SELECT_REG;
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{id}, new
                    BeanPropertyRowMapper<>(Registration.class));
        } catch (Exception e) {
            return null;
        }
    }

    //delete user
    @Override
    public String delete(int id) {
        String query = Constants.DELETE_REG;
        int deleted = jdbcTemplate.update(query, id);
        if (deleted == 1)
            return "success";
        return "Failure";
    }

    // get list of users
    @Override
    public List<Registration> allUsers() {
        {
            List<Registration> registration = jdbcTemplate.query(Constants.SELECT_REG_BY_ROLE, (result, rowNum) -> new Registration(result.getInt("id"),
                    result.getString("firstName"), result.getString("lastName"), result.getString("phoneNumber"), result.getString("role")));
            return registration;
        }
    }

    //update user
    @Override
    public int updatebyId(Registration registration) {
        return jdbcTemplate.update(Constants.UPDATE_REG,
                registration.getFirstName(), registration.getLastName(), registration.getPhoneNumber(), registration.getId());
    }

}
