package com.depromeet.crackerbook.controller.user.dto.response;

import com.depromeet.crackerbook.controller.user.dto.UserDto;
import com.depromeet.crackerbook.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private final UserDto user;

    private UserResponse(User user) {
        this.user = UserDto.from(user);
    }

    public static UserResponse from(User user) {
        return new UserResponse(user);
    }
}
