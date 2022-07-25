package com.example.mbs.impl.controller;

import com.example.mbs.api.MovieBookingService;
import com.example.mbs.api.dto.BookingDto;
import com.example.mbs.api.dto.CityDto;
import com.example.mbs.api.generic.UserDetails;
import com.example.mbs.impl.manager.BookingManager;
import com.example.mbs.impl.util.ResponseEntityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MovieBookingController implements MovieBookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieBookingController.class);


    private final BookingManager bookingManager;

    @Autowired
    public MovieBookingController(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public ResponseEntity<Iterable<CityDto>> getCities() {

        Iterable<CityDto> cities = this.bookingManager.getCities();
        return ResponseEntityBuilder.okOrNotFound(cities);

    }

    @Override
    public ResponseEntity<BookingDto> bookTicket(HttpServletRequest httpServletRequest, BookingDto bookingDto) {

        try {

            UserDetails userContactDetails = getContactDetailsFromRequest(httpServletRequest);
            return ResponseEntityBuilder.okOrNotFound(this.bookingManager.bookTicket(userContactDetails, bookingDto));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private UserDetails getContactDetailsFromRequest(HttpServletRequest httpServletRequest) {

        UserDetails userContactDetails = new UserDetails();
        userContactDetails.setName(httpServletRequest.getHeader("UserName"));
        userContactDetails.setMobile(httpServletRequest.getHeader("UserMobile"));
        userContactDetails.setWhatsApp(httpServletRequest.getHeader("UserWhatsapp"));
        userContactDetails.setEmail(httpServletRequest.getHeader("UserEmail"));
        userContactDetails.setPaymentId(httpServletRequest.getHeader("userPaymentId"));

        return userContactDetails;
    }

}
