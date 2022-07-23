package com.example.mbs.impl.controller;

import com.example.mbs.api.MovieBookingService;
import com.example.mbs.api.dto.CityDto;
import com.example.mbs.impl.manager.BookingManager;
import com.example.mbs.impl.util.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MovieBookingController implements MovieBookingService {

    private final BookingManager bookingManager;

    @Autowired
    public MovieBookingController(BookingManager bookingManager){
        this.bookingManager = bookingManager;
    }

    public ResponseEntity<List<CityDto>> getCities(){

        List<CityDto> cities = this.bookingManager.getCities();
        return ResponseEntityBuilder.okOrNotFound(cities);

    }
}
