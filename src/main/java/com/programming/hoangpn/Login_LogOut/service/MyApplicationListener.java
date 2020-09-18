package com.programming.hoangpn.Login_LogOut.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * @author PhanHoang
 * 9/18/2020
 */
@Slf4j
@Component
public class MyApplicationListener {
    @Autowired
    private LoginAttemptService loginAttemptService;

    @EventListener
    public void authSuccessEventListener(InteractiveAuthenticationSuccessEvent event) {
        // write custom code here for login success audit
        log.info(event.getAuthentication().getName());
        loginAttemptService.loginSucceeded(event.getAuthentication().getName());

    }

    @EventListener
    @Async
    public void onApplicationEvent(LoginFailedEvent event) {
        log.error(event.getMessage());
        loginAttemptService.loginFailed(event.getMessage());
    }

}