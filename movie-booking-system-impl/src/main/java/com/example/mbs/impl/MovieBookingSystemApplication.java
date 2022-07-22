package com.example.mbs.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraReactiveDataAutoConfiguration;

@SpringBootApplication(exclude={CassandraDataAutoConfiguration.class, CassandraReactiveDataAutoConfiguration.class})
public class MovieBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBookingSystemApplication.class, args);
    }

}
