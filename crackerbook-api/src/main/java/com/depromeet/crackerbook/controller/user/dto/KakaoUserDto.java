package com.depromeet.crackerbook.controller.user.dto;

import lombok.Getter;

@Getter
public class KakaoUserDto {

    private Long id;
    private KakaoAccount kakao_account;

    @Getter
    public static class KakaoAccount {
        private boolean email_needs_agreement;
        private boolean is_email_valid;
        private boolean is_email_verified;
        private String email;
    }
}
