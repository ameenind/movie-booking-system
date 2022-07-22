package com.example.moviebookingsystem.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "booking", schema = "public", catalog = "booking")
public class BookingEntity {
    private String id;
    private Object seats;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "seats")
    public Object getSeats() {
        return seats;
    }

    public void setSeats(Object seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(seats, that.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seats);
    }
}
