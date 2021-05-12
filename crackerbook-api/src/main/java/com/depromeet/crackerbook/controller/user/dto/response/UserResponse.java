package com.depromeet.crackerbook.controller.user.dto.response;

import com.depromeet.crackerbook.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {

    private final String email;
    private final String nickname;
    private final String imageUrl;
    private final String introduce;

    public static UserResponse from(User user) {
        return new UserResponse(user.getEmail(), user.getNickname(), user.getImageUrl(), user.getIntroduce());
    }
}
