package com.example.mbs.impl.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Creates response entity based
 */
public final class ResponseEntityBuilder {

    public static <T> ResponseEntity<T> okOrNotFound(T entity) {
        return entity != null ? ResponseEntity.ok(entity) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<List<T>> okOrNotFound(List<T> entityList) {
        return entityList != null && !entityList.isEmpty() ? ResponseEntity.ok(entityList) :
                                                            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
