package com.programming.hoangpn.Login_LogOut.extractPDF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateInfo {
    private Principal issuer;
    private Principal subject;
    private Date validFrom;
    private Date validTo;
    private String errorMessage;

//    public String getErrorMessage() {
//        return errorMessage;
//    }
//
//    public void setErrorMessage(String errorMessage) {
//        this.errorMessage = errorMessage;
//    }
//
//    public void setIssuer(Principal issuer) {
//        this.issuer = issuer;
//    }
//
//    public Principal getIssuer() {
//        return issuer;
//    }
//
//    public void setSubject(Principal subject) {
//        this.subject = subject;
//    }
//
//    public Principal getSubject() {
//        return subject;
//    }
//
//    public void setValidFrom(Date validFrom) {
//        this.validFrom = validFrom;
//    }
//
//    public Date getValidFrom() {
//        return validFrom;
//    }
//
//    public void setValidTo(Date validTo) {
//        this.validTo = validTo;
//    }
//
//    public Date getValidTo() {
//        return validTo;
//    }
}
