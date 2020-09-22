package com.programming.hoangpn.Login_LogOut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author PhanHoang
 * 9/18/2020
 */
@Service
public class PublishEventService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    public void publishLoginFailedEvent(String username) {
        LoginFailedEvent customSpringEvent = new LoginFailedEvent(this, username);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
