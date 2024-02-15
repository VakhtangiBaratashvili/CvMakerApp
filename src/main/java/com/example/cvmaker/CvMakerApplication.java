package com.example.cvmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CvMakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvMakerApplication.class, args);
    }

}
