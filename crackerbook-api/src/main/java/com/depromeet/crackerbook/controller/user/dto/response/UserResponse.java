package com.depromeet.crackerbook.controller.user.dto.response;

import com.depromeet.crackerbook.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class UserResponse {

    private final UserDto user;

    private UserResponse(User user) {
        this.user = new UserDto(user.getEmail(), user.getNickname(), user.getImageUrl(), user.getIntroduce());
    }

    public static UserResponse from(User user) {
        return new UserResponse(user);
    }

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    private static class UserDto {

        private final String email;
        private final String nickname;
        private final String imageUrl;
        private final String introduce;
    }
}
