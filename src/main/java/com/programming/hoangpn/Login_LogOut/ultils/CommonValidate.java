package com.programming.hoangpn.Login_LogOut.ultils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author PhanHoang
 * 6/8/2020
 */
public class CommonValidate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String TEXT_PATTERN = "^[a-zA-Z0-9._]{1,}$";

    public static boolean checkContainSpecialCharacters(final String inputText) {
        pattern = Pattern.compile(TEXT_PATTERN);
        matcher = pattern.matcher(inputText);
        return matcher.matches();
    }
}