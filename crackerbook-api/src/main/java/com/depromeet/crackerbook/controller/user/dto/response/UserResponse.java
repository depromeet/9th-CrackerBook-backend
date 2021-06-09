package com.depromeet.crackerbook.controller.user.dto.response;

import com.depromeet.crackerbook.controller.user.dto.UserDto;
import com.depromeet.crackerbook.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private final UserDto user;

    private UserResponse(User user) {
        this.user = UserDto.of(user);
    }

    public static UserResponse of(User user) {
        return new UserResponse(user);
    }
}
