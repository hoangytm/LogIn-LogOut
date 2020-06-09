package com.programming.hoangpn.Login_LogOut.service;

import com.programming.hoangpn.Login_LogOut.exceptions.BusinessException;
import com.programming.hoangpn.Login_LogOut.model.RefreshToken;
import com.programming.hoangpn.Login_LogOut.repository.RefreshTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {
    @Autowired
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken generateRefreshToken() throws BusinessException {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());
//        try {
//            RefreshToken refreshToken1 = refreshTokenRepository.save(refreshToken);
//        } catch (Exception e) {
//            System.out.println("không save dc vao db");
//            e.printStackTrace();
//        }
        return refreshToken;

    }

    void validateRefreshToken(String token) throws BusinessException {
        refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new BusinessException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token) throws BusinessException {
        refreshTokenRepository.deleteByToken(token);
    }
}
