package com.programming.hoangpn.Login_LogOut.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author PhanHoang
 * 9/22/2020
 */
@Slf4j
public class CommonService {
    public static String getDevice(HttpServletRequest request) {
        String browserDetails = request.getHeader("User-Agent");
        String userAgent = browserDetails;
        String device = "";

        log.info("User Agent for the request is===>" + browserDetails);
        if (userAgent.toLowerCase().contains("windows")) {
            device = "Windows";
        } else if (userAgent.toLowerCase().contains("mac")) {
            device = "Mac";
        } else if (userAgent.toLowerCase().contains("x11")) {
            device = "Unix";
        } else if (userAgent.toLowerCase().contains("android")) {
            device = "Android";
        } else if (userAgent.toLowerCase().contains("iphone")) {
            device = "IPhone";
        } else {
            device = "UnKnown, More-Info: " + userAgent;
        }
        log.info("Operating System======>" + device);
        return device;
    }

    public static String getBrowser(HttpServletRequest request) {
        String browser = "";
        String userAgent = request.getHeader("User-Agent");
        String user = userAgent.toLowerCase();
        if (user.contains("msie")) {
            String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
        } else if (user.contains("safari") && user.contains("version")) {
            browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if (user.contains("opr") || user.contains("opera")) {
            if (user.contains("opera"))
                browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            else if (user.contains("opr"))
                browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
        } else if (user.contains("chrome")) {
            browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else if ((user.contains("mozilla/7.0")) || (user.contains("netscape6")) || (user.contains("mozilla/4.7")) || (user.contains("mozilla/4.78")) || (user.contains("mozilla/4.08")) || (user.contains("mozilla/3"))) {
            browser = "Netscape-?";
        } else if (user.contains("firefox")) {
            browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else if (user.contains("rv")) {
            browser = "IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
        } else {
            browser = "UnKnown, More-Info: " + userAgent;
        }
        log.info("Browser Name==========>" + browser);
        return browser;
    }

    public static String getUserInReqest() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        log.info("H-principal: " + principal.getName());
        return principal.getName();
    }
}
