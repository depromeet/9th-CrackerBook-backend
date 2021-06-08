package com.depromeet.crackerbook.controller.user.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UpdateUserInfoRequest {

    @NotBlank
    private String nickname;

    private String imageUrl;

    private String introduce;
}
