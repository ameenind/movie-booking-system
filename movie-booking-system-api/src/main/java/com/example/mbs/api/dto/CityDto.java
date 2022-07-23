package com.example.mbs.api.dto;

public class CityDto {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;

    @Override
    public String toString() {
        return new StringBuilder().append("CityDto{").append("cityId=").append(id).append(", cityName=").append(name).append('}').toString();
    }
}
