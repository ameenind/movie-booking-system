package com.example.mbs.impl.manager;

import com.example.mbs.api.dto.BookingDto;
import com.example.mbs.api.dto.CityDto;
import com.example.mbs.impl.data.adaptor.DozerMappingWrapper;
import com.example.mbs.impl.data.entity.BookingEntity;
import com.example.mbs.impl.data.entity.CityEntity;
import com.example.mbs.impl.data.repo.BookingRepo;
import com.example.mbs.impl.data.repo.CityRepo;
import org.springframework.stereotype.Component;


@Component
public class BookingManager {

    private final DozerMappingWrapper mapper;
    private final CityRepo cityRepo;
    private final BookingRepo bookingRepo;

    public BookingManager(DozerMappingWrapper mapper, CityRepo cityRepo, BookingRepo bookingRepo) {
        this.cityRepo = cityRepo;
        this.mapper = mapper;
        this.bookingRepo = bookingRepo;
    }

    public Iterable<CityDto> getCities() {

        Iterable<CityEntity> cityRepoAll = cityRepo.findAll();
        Iterable<CityDto> cityDtos = mapper.map(cityRepoAll, CityDto.class);

        return cityDtos;
    }

    public BookingDto bookTicket(BookingDto bookingDto) {

        BookingEntity booking =  mapper.map(bookingDto, BookingEntity.class);
        booking = bookingRepo.save(booking);
        bookingDto = mapper.map(booking, BookingDto.class);
        return bookingDto;
    }
}
