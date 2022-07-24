package com.example.mbs.api;

import com.example.mbs.api.dto.BookingDto;
import com.example.mbs.api.dto.CityDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping(value = "/api/v1")
public interface MovieBookingService {

    @RequestMapping(value = "/cities", method = GET)
    ResponseEntity<Iterable<CityDto>> getCities();

    @PostMapping("/book")
    ResponseEntity<BookingDto> bookTicket(HttpServletRequest httpServletRequest, @RequestBody BookingDto bookingDto);
}
