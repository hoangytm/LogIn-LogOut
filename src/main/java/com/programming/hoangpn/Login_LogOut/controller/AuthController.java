package com.programming.hoangpn.Login_LogOut.controller;

import com.programming.hoangpn.Login_LogOut.dto.AuthenticationResponse;
import com.programming.hoangpn.Login_LogOut.dto.LoginRequest;
import com.programming.hoangpn.Login_LogOut.dto.RefreshTokenRequest;
import com.programming.hoangpn.Login_LogOut.exceptions.BusinessException;
import com.programming.hoangpn.Login_LogOut.service.AuthService;
import com.programming.hoangpn.Login_LogOut.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) throws BusinessException {
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) throws BusinessException {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) throws BusinessException {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }
}
