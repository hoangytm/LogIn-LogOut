package com.programming.hoangpn.Login_LogOut.service;

import com.programming.hoangpn.Login_LogOut.model.UserToken;
import com.programming.hoangpn.Login_LogOut.repository.UserTokenRepository;
import com.programming.hoangpn.Login_LogOut.ultils.CommonService;
import com.programming.hoangpn.Login_LogOut.ultils.Constant;
import org.omg.PortableInterceptor.ACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static com.programming.hoangpn.Login_LogOut.ultils.Constant.*;

/**
 * @author PhanHoang
 * 9/22/2020
 */
@Service
public class UserTokenService {
    @Autowired
    private UserTokenRepository userTokenRepository;

    public List<UserToken> getUserTokens() {
        return userTokenRepository.findAllByUserName(CommonService.getUserInReqest());
    }

    public UserToken getUserTokenById(Integer id) {
        return userTokenRepository.getUserTokenById(id);

    }

    public UserToken changeStatus(Integer id) {
        UserToken userToken = getUserTokenById(id);
        userToken.setIsActive(userToken.getIsActive().equals(ACTIVE) ? DEACTIVATE : ACTIVE);
        userTokenRepository.save(userToken);
        return userToken;
    }

}
