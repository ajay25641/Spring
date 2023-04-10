package org.example.eazyschool.repository;

import org.example.eazyschool.Model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidaysRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Holiday> findAllHolidays(){
        String query="SELECT * FROM HOLIDAYS;";
        var rowMapper= BeanPropertyRowMapper.newInstance(Holiday.class);
        return jdbcTemplate.query(query,rowMapper);
    }
}
