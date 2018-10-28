package com.example.testing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserService userService;

    @Autowired
    public AccountService(AccountRepository ar, UserService us) {
        this.accountRepository = ar;
        this.userService = us;
    }

    public List<Account> getUserAccounts() {
        return Optional.ofNullable(userService.getAuthenticatedUser())
                .map(u -> accountRepository.findAccountsByUsername(u.getUsername()))
                .orElse(Collections.emptyList());
    }
}
