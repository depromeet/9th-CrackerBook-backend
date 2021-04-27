package com.depromeet.crackerbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }
}
