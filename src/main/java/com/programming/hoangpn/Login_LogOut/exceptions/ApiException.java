package com.programming.hoangpn.Login_LogOut.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author PhanHoang
 * 6/3/2020
 */

public class ApiException {
    public final String message;
    //    public final Throwable throwable;
    public final HttpStatus status;
    public final int code = HttpStatus.BAD_REQUEST.value();
    public final ZonedDateTime timestamp;

    public ApiException(String message, HttpStatus status, ZonedDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }
}
