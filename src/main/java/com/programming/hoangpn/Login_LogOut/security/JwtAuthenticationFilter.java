package com.programming.hoangpn.Login_LogOut.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programming.hoangpn.Login_LogOut.exceptions.ApiException;
import com.programming.hoangpn.Login_LogOut.exceptions.BusinessException;
import com.programming.hoangpn.Login_LogOut.ultils.ConvertToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static com.programming.hoangpn.Login_LogOut.ultils.ConvertToJson.convertObjectToJson;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,

                                    FilterChain filterChain) throws BusinessException, ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);
            if (StringUtils.hasText(jwt) && jwtProvider.validateToken(jwt)) {
                String username = jwtProvider.getUsernameFromJwt(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            }
            filterChain.doFilter(request, response);
        } catch (RuntimeException e) {
            HttpStatus badRequest = HttpStatus.BAD_REQUEST;
            BusinessException errorResponse = new BusinessException(e.getMessage());
            ApiException apiException = new ApiException(
                    e.getMessage(),
                    badRequest, ZonedDateTime.now(ZoneId.of("Z"))
            );
            response.getOutputStream().println(ConvertToJson.convertObjectToJson(new ResponseEntity<>(apiException, badRequest).getBody()));
//            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.getWriter().write(convertObjectToJson(errorResponse));
        }

    }
    private String getJwtFromRequest(HttpServletRequest request) throws BusinessException{
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return bearerToken;
    }
}
