package com.programming.hoangpn.Login_LogOut.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author PhanHoang
 * 6/3/2020
 */
@AllArgsConstructor
public class ApiException {
    public final String message;
    //    public final Throwable throwable;
    public final HttpStatus status;
    public final ZonedDateTime timestap;


}
