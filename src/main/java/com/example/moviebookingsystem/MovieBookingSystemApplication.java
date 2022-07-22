package com.example.moviebookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraReactiveDataAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={CassandraDataAutoConfiguration.class, CassandraReactiveDataAutoConfiguration.class})
public class MovieBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBookingSystemApplication.class, args);
    }

}
