package com.example.mbs.impl.manager;

import com.example.mbs.api.dto.BookingDto;
import com.example.mbs.api.dto.CityDto;
import com.example.mbs.impl.data.adaptor.DozerMappingWrapper;
import com.example.mbs.impl.data.entity.BookingEntity;
import com.example.mbs.impl.data.entity.CityEntity;
import com.example.mbs.impl.data.entity.ShowEntity;
import com.example.mbs.impl.data.repo.BookingRepo;
import com.example.mbs.impl.data.repo.CityRepo;
import com.example.mbs.impl.data.repo.ShowRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Component
public class BookingManager {

    private final DozerMappingWrapper mapper;
    private final CityRepo cityRepo;
    private final BookingRepo bookingRepo;
    private final ShowRepo showRepo;

    final int SHORT_ID_LENGTH = 8;

    public BookingManager(DozerMappingWrapper mapper, CityRepo cityRepo, BookingRepo bookingRepo, ShowRepo showRepo) {
        this.cityRepo = cityRepo;
        this.mapper = mapper;
        this.bookingRepo = bookingRepo;
        this.showRepo = showRepo;
    }

    public Iterable<CityDto> getCities() {

        Iterable<CityEntity> cityRepoAll = cityRepo.findAll();
        Iterable<CityDto> cityDtos = mapper.map(cityRepoAll, CityDto.class);

        return cityDtos;
    }

    @Transactional
    public BookingDto bookTicket(BookingDto bookingDto) throws Exception {

        if (bookingDto.getId() != null) throw new Exception("Invalid request for booking");

        if (bookingDto.getSeats() == null || bookingDto.getSeats().size() == 0 || bookingDto.getSeats().values().size() == 0) {
            throw new Exception("No seat information provided");
        }

        Optional<ShowEntity> showObject = showRepo.findById(bookingDto.getShowId());

        if (showObject.isEmpty()) {
            throw new Exception("Invalid show id provided");
        }

        ShowEntity show = showObject.get();

        for (Map.Entry<String, List<Integer>> entry : bookingDto.getSeats().entrySet()) {

            List<Integer> seats = show.getAvailableSeats().get(entry.getKey());

            if (seats == null) throw new Exception("Given seats does not available / exists");

            for (Integer i : entry.getValue()) {
                if (!seats.remove(i)) throw new Exception("Given seats does not available / exists");
            }
        }

        showRepo.save(show);

        String shortId = RandomStringUtils.randomAlphanumeric(SHORT_ID_LENGTH);
        bookingDto.setId(shortId);
        BookingEntity booking = mapper.map(bookingDto, BookingEntity.class);
        booking = bookingRepo.save(booking);
        bookingDto = mapper.map(booking, BookingDto.class);
        return bookingDto;
    }
}
