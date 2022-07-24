package com.example.mbs.api.dto;


import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class BookingDto {
    private String id;
    private Map<String, List<Integer>> seats;
    private Long showId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, List<Integer>> seats) {
        this.seats = seats;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "id='" + id + '\'' +
                ", seats=" + seats +
                ", showId=" + showId +
                '}';
    }
}
