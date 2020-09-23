package com.programming.hoangpn.Login_LogOut.extractPDF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author PhanHoang
 * 9/23/2020
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Signature {
    private List<SignatureInfo> signatureInfos;
    private String errorMessage;
}
