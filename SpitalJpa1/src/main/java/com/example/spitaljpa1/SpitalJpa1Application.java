package com.example.spitaljpa1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpitalJpa1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpitalJpa1Application.class, args);
    }

}
