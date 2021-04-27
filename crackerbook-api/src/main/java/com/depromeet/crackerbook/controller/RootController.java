package com.depromeet.crackerbook.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class RootController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/health-check")
    public String healthCheck(){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return String.format("OK %s [%s]", activeProfile, now);
    }
}
