package com.programming.hoangpn.Login_LogOut.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 6/8/2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse {
    private  int code;
    private int status;
    private String message;
    private Object data;

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}