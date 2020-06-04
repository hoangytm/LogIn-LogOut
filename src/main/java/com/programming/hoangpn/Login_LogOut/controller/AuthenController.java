package com.programming.hoangpn.Login_LogOut.controller;

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
        return " success";
    }

    @GetMapping("/au")
    public String notAuthen() {
        System.out.println("please say something");
//        throw new BusinessException("sai mat khuA");
        return "failed";
    }
}
