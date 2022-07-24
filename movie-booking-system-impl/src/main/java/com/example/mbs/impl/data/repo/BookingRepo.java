package com.example.mbs.impl.data.repo;

import com.example.mbs.impl.data.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepo extends CrudRepository<BookingEntity, String> {

}
