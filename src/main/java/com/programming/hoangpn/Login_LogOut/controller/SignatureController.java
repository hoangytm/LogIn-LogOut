package com.programming.hoangpn.Login_LogOut.controller;

import com.programming.hoangpn.Login_LogOut.extractPDF.Signature;
import com.programming.hoangpn.Login_LogOut.extractPDF.SignatureTestHelper;
import com.programming.hoangpn.Login_LogOut.model.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author PhanHoang
 * 9/23/2020
 */
@RestController
@RequestMapping("/signature")
public class SignatureController {
    @PostMapping(value = "/info")
    public ApiResponse getSignatureInfo(@RequestParam("file") MultipartFile uploadFile)
            throws IOException, GeneralSecurityException {
        SignatureTestHelper signatureTestHelper = new SignatureTestHelper();
        Signature signature = signatureTestHelper.getSignatureInfor(uploadFile);
        return ApiResponse.builder().code(200).message("success").status(200).data(signature).build();
    }
}
