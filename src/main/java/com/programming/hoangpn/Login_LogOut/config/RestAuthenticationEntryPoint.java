package com.programming.hoangpn.Login_LogOut.config;

import com.programming.hoangpn.Login_LogOut.exceptions.ApiException;
import com.programming.hoangpn.Login_LogOut.exceptions.BusinessException;
import com.programming.hoangpn.Login_LogOut.utils.ConvertToJson;
import io.jsonwebtoken.io.IOException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author PhanHoang
 * 6/5/2020
 */
@Configuration("restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, java.io.IOException {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        BusinessException e = new BusinessException("you did not have authorization for access this link");
        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest, ZonedDateTime.now(ZoneId.of("Z"))
        );
        response.getOutputStream().println(ConvertToJson.convertObjectToJson(new ResponseEntity<>(apiException, badRequest).getBody()));

    }
}