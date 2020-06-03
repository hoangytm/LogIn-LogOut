package com.programming.techie.springredditclone.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @author PhanHoang
 * 6/3/2020
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({BusinessException.class})
    public final ResponseEntity<?> handleValidationExceptions(RuntimeException ex) {
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("success");
    }

//    private ResponseEntity<?> createResponse(ResponseStatusCode response) {
//        OCSPResponse.ResponseStatus responseStatus = new ResponseStatus(response.getHttpCode().toString(), true);
//        GeneralResponse<Object> responseObject = new GeneralResponse<>();
//        responseObject.setStatus(responseStatus);
//        return new ResponseEntity<>(responseObject, response.getHttpCode());
//    }

}