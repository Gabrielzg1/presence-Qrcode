package com.example.presenceqrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.example.presenceqrcode")
@SpringBootApplication
public class PresenceQrcodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(PresenceQrcodeApplication.class, args);
        System.out.println("Server on: http://localhost:8080");
    }

}
