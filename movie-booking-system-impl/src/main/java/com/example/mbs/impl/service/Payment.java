package com.example.mbs.impl.service;

import com.example.mbs.api.generic.UserDetails;
import org.springframework.stereotype.Component;

import javax.json.JsonObject;
import java.util.List;
import java.util.Map;

@Component
public class Payment {

    public boolean validatePayment(UserDetails userContactDetails, Map<String, List<Integer>> seats){

        // Handle the payment service using the payment gateway service
        // To be implemented
        return false;
    }

    public void refundPayment(String paymentId, UserDetails userContactDetails, String bookingId){
        // Cancel payment
        // To be implemented
    }

    public JsonObject getPaymentDetails(String paymentId){
        // To be implemented
        return null;
    }
}
