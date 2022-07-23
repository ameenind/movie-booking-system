package com.example.mbs.impl.data.entity;

import com.example.mbs.impl.data.converter.JpaConverterJson;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "booking", schema = "public", catalog = "booking")
public class BookingEntity {
    private String id;
    private Map<String, Set<Integer>> seats;
    private Long showId;

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
    @Convert(converter = JpaConverterJson.class)
    public Map<String, Set<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Set<Integer>> seats) {
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

    @Basic
    @Column(name = "show_id")
    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
