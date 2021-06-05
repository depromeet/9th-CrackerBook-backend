package com.depromeet.crackerbook.util;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.exception.NotFoundApiException;
import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;

@UtilityClass
public class RequestUtil {

    public static Long getUserId(HttpServletRequest request) {
        String accessToken = getAccessToken(request);
        Long userId = JwtUtil.extractUserId(accessToken);

        if (userId == null) {
            throw new NotFoundApiException(ErrorCode.INVALID_USER);
        }
        return userId;
    }

    private String getAccessToken(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
}
