package com.works.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Rest {

    public static ResponseEntity success(Object obj) {
        return ResponseEntity.ok().body(obj);
    }

    public static ResponseEntity fail(Object obj, HttpStatus status) {
        return new ResponseEntity(obj, status);
    }

}
