package com.myspring.database.databasedemo.bean;

import java.time.LocalDateTime;
import java.util.Date;

public class Person {

    public int Id;
    public String Name;
    public String Location;
    public LocalDateTime birthDate;

    public Person(){

    }
    public Person(int id, String name, String location, LocalDateTime birthDate) {
        Id = id;
        Name = name;
        Location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
