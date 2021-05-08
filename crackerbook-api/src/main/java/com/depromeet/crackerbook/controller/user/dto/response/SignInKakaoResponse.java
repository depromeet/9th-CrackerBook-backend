package com.depromeet.crackerbook.controller.user.dto.response;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignInKakaoResponse implements Serializable {

    private String accessToken;
    private String refreshToken;

    public static SignInKakaoResponseBuilder builder(String accessToken, String refreshToken) {
        return new SignInKakaoResponseBuilder()
                .accessToken(accessToken)
                .refreshToken(refreshToken);
    }
}
