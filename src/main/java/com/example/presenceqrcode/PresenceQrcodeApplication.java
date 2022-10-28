package com.example.presenceqrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PresenceQrcodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(PresenceQrcodeApplication.class, args);
        System.out.println("Server on: http://localhost:8080");
    }

}
