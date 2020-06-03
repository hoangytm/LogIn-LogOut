package com.programming.techie.springredditclone.exceptions;


import lombok.Data;



@Data
public class BusinessException extends RuntimeException {
    private String errCode;
    private String errMsg;
    public BusinessException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }
//
    public BusinessException(String exMessage) {
        super(exMessage);
    }
}
