package com.programming.hoangpn.Login_LogOut.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author PhanHoang
 * 6/8/2020
 */
@Slf4j
public class CommonValidate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String TEXT_PATTERN = "^[a-zA-Z0-9._]{1,}$";

    public static boolean checkContainSpecialCharacters(final String inputText) {
        pattern = Pattern.compile(TEXT_PATTERN);
        matcher = pattern.matcher(inputText);
        return matcher.matches();
    }

    public static Object replaceNullByEmpty(Object obj) {
        if (obj == null) return "";
        return obj;
    }
}
