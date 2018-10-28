package com.example.testing;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;


@Entity
@Data
@ToString
public class Account {
    private Long id;

    private String username;

    private AccountNumber accountNumber;

    private Boolean defaultAccount;

    public Account() {
        this.defaultAccount = false;
    }

    public Account(String username, AccountNumber accountNumber) {
        this();
        this.username = username;
        this.accountNumber = accountNumber;
        this.defaultAccount = false;
    }

    public Account(String username, String accountNumber) {
        this();
        this.username = username;
        this.accountNumber = new AccountNumber(accountNumber);
        this.defaultAccount = false;
    }


}
