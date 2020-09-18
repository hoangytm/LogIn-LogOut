package com.programming.hoangpn.Login_LogOut.service;

import org.springframework.context.ApplicationEvent;

/**
 * @author PhanHoang
 * 9/18/2020
 */
public class LoginFailedEvent extends ApplicationEvent {
    private String message;

    public LoginFailedEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
