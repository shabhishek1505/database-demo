package com.myspring.database.databasedemo.jdbc;

import com.myspring.database.databasedemo.bean.Person;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Repository
public class PersonJdbcDao {


    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
           Person person= new Person();
           person.setId(rs.getInt("id"));
           person.setName(rs.getString("name"));
           person.setLocation(rs.getString("location"));
           person.setBirthDate(rs.getTimestamp("birth_date").toLocalDateTime());
           return person;
        }
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> getAll() {
        return jdbcTemplate.query("select * from Person", new PersonRowMapper());
    }

    public Person getById(int id) {
        return jdbcTemplate.queryForObject("select * from Person where id=?",
                new PersonRowMapper(), new Object[]{id});
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from Person where id=?", new Object[]{id});
    }

    public int createPerson(Person person) {
        return jdbcTemplate.update("INSERT into Person VALUES (?,?,?,?)", new Object[]{person.getId(), person.getName(), person.getLocation(), person.getBirthDate()});
    }

    public int updatePerson(Person person) {
        return jdbcTemplate.update("UPDATE Person Set Name=?," + "location=?," + "birth_date=?" + "where id=?", new Object[]{person.getName(), person.getLocation(), person.getBirthDate(), person.getId()});
    }
}
