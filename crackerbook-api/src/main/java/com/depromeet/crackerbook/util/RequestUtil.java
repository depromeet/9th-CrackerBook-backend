package com.depromeet.crackerbook.util;

import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;

@UtilityClass
public class RequestUtil {

    public static Long getUserId(HttpServletRequest request) {
        String accessToken = getAccessToken(request);
        return JwtUtil.extractUserId(accessToken);
    }

    private String getAccessToken(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
}
