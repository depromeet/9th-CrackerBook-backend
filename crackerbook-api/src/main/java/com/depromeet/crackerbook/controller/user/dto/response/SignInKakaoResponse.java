package com.depromeet.crackerbook.controller.user.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignInKakaoResponse implements Serializable {

    private String accessToken;

    @Builder
    private SignInKakaoResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
