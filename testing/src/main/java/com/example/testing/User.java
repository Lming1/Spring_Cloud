package com.example.testing;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private Long createdAt;

    private Long lastModified;

    public User() {
    }

    public User(Long id, String username, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
