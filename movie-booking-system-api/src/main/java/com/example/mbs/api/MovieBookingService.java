package com.example.mbs.api;

import com.example.mbs.api.dto.CityDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping(value = "/api/v1")
public interface MovieBookingService {

    @RequestMapping(value = "/cities", method = GET)
    ResponseEntity<List<CityDto>> getCities();
}
