package com.programming.hoangpn.Login_LogOut.controller;

import com.programming.hoangpn.Login_LogOut.model.ApiResponse;
import com.programming.hoangpn.Login_LogOut.model.UserToken;
import com.programming.hoangpn.Login_LogOut.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PhanHoang
 * 9/22/2020
 */
@RestController
@RequestMapping("/user-token")
public class UserController {
    @Autowired
    private UserTokenService userTokenService;

    @GetMapping
    public ApiResponse getHistoryLogin() {
        List<UserToken> history = userTokenService.getUserTokens();
        return ApiResponse.builder().code(200).data(history).status(200).message("success").build();
    }

    @PutMapping("/{id}")
    public ApiResponse changeStatus(@PathVariable Integer id) {
        UserToken userToken = userTokenService.changeStatus(id);
        return ApiResponse.builder().code(200).data(userToken).status(200).message("success").build();
    }
}
