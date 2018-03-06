package com.middleware.common.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    /**
     * 设置cookie
     *
     * @param response response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期  以天为单位
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, encode(value));
        cookie.setPath("/");
        try {
            cookie.setMaxAge(maxAge * 12 * 60 * 60);
        } catch (Exception e) {
            cookie.setMaxAge(Integer.MAX_VALUE);
        }
        response.addCookie(cookie);
    }

    /**
     * 根据名字获取cookie
     *
     * @param request request
     * @param name    cookie名字
     * @return Cookie
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = cookieMap.get(name);
            return decode(cookie.getValue());
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request request
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    private static String decode(String value) {
        String result = "";
        if (StringUtils.isNotEmpty(value)) {
            try {
                result = URLDecoder.decode(value, "utf-8");
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }
        return result;
    }

    private static String encode(String value) {
        String result = "";
        if (StringUtils.isNotEmpty(value)) {
            try {
                result = URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }
        return result;
    }
}
