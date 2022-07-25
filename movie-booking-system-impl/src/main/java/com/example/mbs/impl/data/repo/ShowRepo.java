package com.example.mbs.impl.data.repo;

import com.example.mbs.impl.data.entity.CityEntity;
import com.example.mbs.impl.data.entity.ShowEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepo extends CrudRepository<ShowEntity, Long> {

}
