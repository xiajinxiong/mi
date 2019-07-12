package com.sure.mi.util;

import javax.servlet.http.Cookie;

public class UserNameUtil {

    public static String getUsername(Cookie[] cookies) {
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username") && cookie.getValue() != null
            && !cookie.getValue().equals("")) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
