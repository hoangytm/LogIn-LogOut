package com.programming.hoangpn.Login_LogOut.controller;

import com.programming.hoangpn.Login_LogOut.exceptions.BusinessException;
import com.programming.hoangpn.Login_LogOut.model.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PhanHoang
 * 6/3/2020
 */
@RestController
@RequestMapping("/authen")
public class AuthenController {
    @GetMapping
    public String checkAuthen() {
        System.out.println(" success");
        throw new BusinessException("exception");
    }

    @GetMapping("/au")
    public ApiResponse notAuthen() {
        System.out.println("please say something");
        return  ApiResponse.builder().code(200).message("success").status(200).data("success").build();
    }
}
