package com.example.demo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String email;

    public Customer(long id, String email) {
    }
}
