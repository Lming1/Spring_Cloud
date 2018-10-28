package com.example.user.demo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.security.Principal;

@Data
@ToString
@Entity
public class User extends BaseEntity implements Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    public User() {

    }


    public User(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Transient
    @Override
    public String getName() {
        return username;
    }
}
