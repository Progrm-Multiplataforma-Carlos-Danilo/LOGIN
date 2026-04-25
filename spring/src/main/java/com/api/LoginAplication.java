package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@EnableMethodSecurity
@SpringBootApplication

public class LoginAplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginAplication.class, args);
    }

}