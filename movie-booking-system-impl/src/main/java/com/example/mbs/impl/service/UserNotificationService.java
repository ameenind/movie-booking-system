package com.example.mbs.impl.service;

import com.example.mbs.api.dto.BookingDto;
import com.example.mbs.api.generic.UserContactDetails;
import org.springframework.stereotype.Component;

@Component
public class UserNotificationService {

    public void PrepareNotification(UserContactDetails contactDetails, BookingDto booking){
        // Push the booking details into message queue for notifying user
        // To be implemented
    }
}
