/*
 * Copyright (c) 2021 General Electric Company. All rights reserved.
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
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
