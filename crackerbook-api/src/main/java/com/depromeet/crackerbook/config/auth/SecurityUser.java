package com.depromeet.crackerbook.config.auth;

import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

public class SecurityUser extends User {

    public SecurityUser(String email) {
        super(email, email, new ArrayList<>());
    }
}
