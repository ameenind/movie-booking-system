package com.example.mbs.api.dto;


import java.util.Date;
import java.util.Map;
import java.util.Set;

public class ShowDto {
    private long id;
    private Date schedule;
    private Map<String, Set<Integer>> availableSeats;
    private int movieId;
    private int audiId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }


    public Map<String, Set<Integer>> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Map<String, Set<Integer>> availableSeats) {
        this.availableSeats = availableSeats;
    }


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getAudiId() {
        return audiId;
    }

    public void setAudiId(int audiId) {
        this.audiId = audiId;
    }
}
