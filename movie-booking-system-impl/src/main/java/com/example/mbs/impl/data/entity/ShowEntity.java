package com.example.mbs.impl.data.entity;

import com.example.mbs.impl.data.converter.JpaConverterJson;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "show", schema = "public", catalog = "booking")
public class ShowEntity {
    private long id;
    private Date schedule;
    private Map<String, List<Integer>> availableSeats;
    private int movieId;
    private int audiId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "schedule")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    @Basic
    @Column(name = "available_seats")
    @Convert(converter = JpaConverterJson.class)
    public Map<String, List<Integer>> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Map<String, List<Integer>> availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowEntity that = (ShowEntity) o;
        return id == that.id && Objects.equals(schedule, that.schedule) && Objects.equals(availableSeats, that.availableSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schedule, availableSeats);
    }

    @Basic
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "audi_id")
    public int getAudiId() {
        return audiId;
    }

    public void setAudiId(int audiId) {
        this.audiId = audiId;
    }
}
