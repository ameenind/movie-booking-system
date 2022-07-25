package com.example.mbs.impl.data.entity;

import com.example.mbs.impl.data.converter.JpaConverterJson;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "booking", schema = "public", catalog = "booking")
public class BookingEntity {
    private String id;
    private Map<String, List<Integer>> seats;
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
    //@Type(type = "jsonb")
    @Column(name = "seats")
    @Convert(converter = JpaConverterJson.class)
    public Map<String, List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, List<Integer>> seats) {
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
