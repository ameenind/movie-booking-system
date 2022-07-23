package com.example.mbs.impl.data.entity;

import com.example.mbs.impl.data.converter.JpaConverterJson;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "audi", schema = "public", catalog = "booking")
public class AudiEntity {
    private int id;
    private String name;
    private Map<String, Set<Integer>> seats;
    private String layoutLink;
    private long cinemaId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Basic
    @Column(name = "layout_link")
    public String getLayoutLink() {
        return layoutLink;
    }

    public void setLayoutLink(String layoutLink) {
        this.layoutLink = layoutLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AudiEntity that = (AudiEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(seats, that.seats) && Objects.equals(layoutLink, that.layoutLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, seats, layoutLink);
    }

    @Basic
    @Column(name = "cinema_id")
    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }
}
