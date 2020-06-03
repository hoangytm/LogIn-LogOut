package com.programming.techie.springredditclone.controller;

import com.programming.techie.springredditclone.exceptions.BusinessException;
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
    public String checkAuthen(){
        return " success";
    }
    @GetMapping("/au")
    public String notAuthen() throws BusinessException {
        return "failed";
    }
}
