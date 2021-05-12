package com.depromeet.crackerbook.controller.user.dto.request;

import lombok.Getter;

@Getter
public class UpdateUserInfoRequest {

    private String nickname;
    private String imageUrl;
    private String introduce;
}
