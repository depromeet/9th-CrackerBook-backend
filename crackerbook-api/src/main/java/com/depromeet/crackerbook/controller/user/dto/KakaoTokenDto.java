package com.depromeet.crackerbook.controller.user.dto;

import lombok.Getter;

@Getter
public class KakaoTokenDto {

    private String token_type;
    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private Integer refresh_token_expires_in;
    private String scope;
}
