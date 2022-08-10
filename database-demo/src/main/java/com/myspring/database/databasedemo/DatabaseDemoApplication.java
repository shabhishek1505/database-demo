package com.myspring.database.databasedemo;

import com.myspring.database.databasedemo.bean.Person;
import com.myspring.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args){
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("All Users {}",personJdbcDao.getAll());

		logger.info("1001 User {}",personJdbcDao.getById(1001));

		personJdbcDao.createPerson(new Person(1005,"newName",
				"newLocation", LocalDateTime.now()));
	}
}
