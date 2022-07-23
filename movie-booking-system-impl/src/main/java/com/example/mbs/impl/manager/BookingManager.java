package com.example.mbs.impl.manager;

import com.example.mbs.api.dto.CityDto;
import com.example.mbs.impl.data.adaptor.DozerMappingWrapper;
import com.example.mbs.impl.data.entity.CityEntity;
import com.example.mbs.impl.data.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingManager {

    private final DozerMappingWrapper mapper;
    private final CityRepo cityRepo;

    public BookingManager(CityRepo cityRepo, DozerMappingWrapper mapper) {
        this.cityRepo = cityRepo;
        this.mapper = mapper;
    }

    public List<CityDto> getCities() {

        return mapper.map(cityRepo.findAll(), CityDto.class);
    }
}
