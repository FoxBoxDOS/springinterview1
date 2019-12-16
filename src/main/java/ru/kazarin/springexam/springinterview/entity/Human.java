package ru.kazarin.springexam.springinterview.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name= "users")
public class Human {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;

    public Human(){
    }

    public Human(String firstname, String lastname){
        this.firstname=firstname;
        this.lastname=lastname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }


}
