package com.example.mbs.impl.manager;

import com.example.mbs.api.dto.BookingDto;
import com.example.mbs.api.dto.CityDto;
import com.example.mbs.api.generic.UserContactDetails;
import com.example.mbs.impl.data.adaptor.DozerMappingWrapper;
import com.example.mbs.impl.data.entity.BookingEntity;
import com.example.mbs.impl.data.entity.CityEntity;
import com.example.mbs.impl.data.entity.ShowEntity;
import com.example.mbs.impl.data.repo.AudiRepo;
import com.example.mbs.impl.data.repo.BookingRepo;
import com.example.mbs.impl.data.repo.CityRepo;
import com.example.mbs.impl.data.repo.ShowRepo;
import com.example.mbs.impl.service.TheatrePartner;
import com.example.mbs.impl.service.UserNotificationService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Component
public class BookingManager {

    private final DozerMappingWrapper mapper;
    private final TheatrePartner theatrePartner;
    private final UserNotificationService userNotificationService;
    private final CityRepo cityRepo;
    private final BookingRepo bookingRepo;
    private final ShowRepo showRepo;
    private final AudiRepo audiRepo;

    final int SHORT_ID_LENGTH = 8;

    public BookingManager(DozerMappingWrapper mapper, TheatrePartner theatrePartner, UserNotificationService userNotificationService, CityRepo cityRepo, BookingRepo bookingRepo, ShowRepo showRepo, AudiRepo audiRepo) {
        this.mapper = mapper;
        this.theatrePartner = theatrePartner;
        this.userNotificationService = userNotificationService;
        this.cityRepo = cityRepo;
        this.bookingRepo = bookingRepo;
        this.showRepo = showRepo;
        this.audiRepo = audiRepo;
    }

    public Iterable<CityDto> getCities() {

        Iterable<CityEntity> cityRepoAll = cityRepo.findAll();

        return mapper.map(cityRepoAll, CityDto.class);
    }

    @Transactional
    public BookingDto bookTicket(UserContactDetails user,  BookingDto bookingDto) throws Exception {

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

        // Remove the mentioned seats from the show table
        showRepo.save(show);

        Long cinemaId = audiRepo.findById(show.getAudiId()).get().getCinemaId();

        if(!theatrePartner.LockSeats(cinemaId, bookingDto.getSeats())) {
            throw new Exception("Given seats does not available / exists");
        }

        if(!theatrePartner.BookSeats(cinemaId, bookingDto.getSeats())) {
            throw new Exception("Given seats does not available / exists");
        }

        // Finally, creation of the booking in the system
        String shortId = RandomStringUtils.randomAlphanumeric(SHORT_ID_LENGTH);
        bookingDto.setId(shortId);
        BookingEntity booking = mapper.map(bookingDto, BookingEntity.class);
        booking = bookingRepo.save(booking);
        bookingDto = mapper.map(booking, BookingDto.class);

        userNotificationService.PrepareNotification(user, bookingDto);

        return bookingDto;
    }
}
