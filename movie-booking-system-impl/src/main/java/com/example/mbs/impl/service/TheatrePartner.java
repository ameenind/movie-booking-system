package com.example.mbs.impl.service;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TheatrePartner {

    // This method will lock the mentioned seats for a specified time,
    // theatre will automatically unlock the seats on timeout
    // Return true if successful
    public boolean LockSeats(Long theatreId, Map<String, List<Integer>> seats){

        // Not implemented
        return false;
    }

    // This method will unlock the mentioned seats for a specified time,
    // theatre will automatically unlock the seats on timeout

    public void UnLockSeats(Long theatreId, Map<String, List<Integer>> seats){

        // Not implemented
    }

    // This method will book the mentioned seats,
    // Return true if successful
    public boolean BookSeats(Long theatreId, Map<String, List<Integer>> seats){

        // Not implemented
        return false;
    }

    // This method will cancel the mentioned seats,
    // Return true if successful
    public boolean CancelBooking(Long theatreId, Map<String, List<Integer>> seats){

        // Not implemented
        return false;
    }
}
