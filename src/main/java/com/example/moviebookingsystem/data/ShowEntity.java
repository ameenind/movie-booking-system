package com.example.moviebookingsystem.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "show", schema = "public", catalog = "booking")
public class ShowEntity {
    private long id;
    private Object schedule;
    private Object availableSeats;

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
    public Object getSchedule() {
        return schedule;
    }

    public void setSchedule(Object schedule) {
        this.schedule = schedule;
    }

    @Basic
    @Column(name = "available_seats")
    public Object getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Object availableSeats) {
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
}
