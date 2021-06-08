package com.depromeet.crackerbook.controller.user.dto;

import com.depromeet.crackerbook.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {

    private final String email;
    private final String nickname;
    private final String imageUrl;
    private final String introduce;

    public static UserDto of(User user) {
        return new UserDto(
                user.getEmail()
                , user.getNickname()
                , user.getImageUrl()
                , user.getIntroduce()
        );
    }
}
