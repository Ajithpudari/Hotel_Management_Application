package com.hotel.management.repository;

import com.hotel.management.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {



    @Autowired
    JdbcTemplate template;
    private String user;

    public String getRole(String name) {
        String query = Constants.SELECT_REG_ROLE;
        template.update(query, name);
        return "";
    }
}

