package com.programming.hoangpn.Login_LogOut.config;

import io.jsonwebtoken.io.IOException;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author PhanHoang
 * 6/5/2020
 */
@Configuration("restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            response.getOutputStream().println("{ \"error\": \"" + authenticationException.getMessage() + "\" }");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}