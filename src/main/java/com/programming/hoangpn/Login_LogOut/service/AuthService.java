package com.programming.hoangpn.Login_LogOut.service;
import com.programming.hoangpn.Login_LogOut.dto.AuthenticationResponse;
import com.programming.hoangpn.Login_LogOut.dto.LoginRequest;
import com.programming.hoangpn.Login_LogOut.dto.RefreshTokenRequest;
import com.programming.hoangpn.Login_LogOut.exceptions.BusinessException;
import com.programming.hoangpn.Login_LogOut.model.User;
import com.programming.hoangpn.Login_LogOut.model.UserToken;
import com.programming.hoangpn.Login_LogOut.repository.UserRepository;
import com.programming.hoangpn.Login_LogOut.repository.UserTokenRepository;
import com.programming.hoangpn.Login_LogOut.security.JwtProvider;
import com.programming.hoangpn.Login_LogOut.utils.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;

import static com.programming.hoangpn.Login_LogOut.utils.Constant.ACTIVE;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    private UserTokenRepository userTokenRepository;
    @Autowired
    private PublishEventService publishEventService;

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }

    @Transactional
    public AuthenticationResponse login(LoginRequest loginRequest) {
        AuthenticationResponse authenticationResponse;
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername()
                            , loginRequest.getPassword())
                    );
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            String token = jwtProvider.generateToken(authenticate);
//            lấy thông tin request
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .currentRequestAttributes())
                    .getRequest();
            String ip = "";
            if (request != null) {
                ip = request.getHeader("X-FORWARDED-FOR");
                if (ip == null || "".equals(ip)) {
                    ip = request.getRemoteAddr();
                }
            }
            UserToken userToken = UserToken.builder()
                    .toKen(token)
                    .userName(loginRequest.getUsername())
                    .createTime(new Date())
                    .ip(ip)
                    .device(CommonService.getDevice(request))
                    .browser(CommonService.getBrowser(request))
                    .isActive(ACTIVE)
                    .build();
            userTokenRepository.save(userToken);
            authenticationResponse = AuthenticationResponse.builder()
                    .authenticationToken(token)
                    .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                    .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                    .username(loginRequest.getUsername())
                    .build();
        } catch (Exception e) {
            publishEventService.publishLoginFailedEvent(loginRequest.getUsername());
            throw new BusinessException(e.getMessage());
        }

        return authenticationResponse;
    }


    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(refreshTokenRequest.getUsername())
                .build();
    }
}