package com.depromeet.crackerbook.controller.user.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignInKakaoResponse implements Serializable {

    private final String accessToken;

    public static SignInKakaoResponse of(String accessToken) {
        return new SignInKakaoResponse(accessToken);
    }
}
