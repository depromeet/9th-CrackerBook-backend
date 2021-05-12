package com.depromeet.crackerbook.controller.user;

import com.depromeet.crackerbook.config.auth.UserDetailsServiceImpl;
import com.depromeet.crackerbook.controller.user.dto.KakaoUserDto;
import com.depromeet.crackerbook.controller.user.dto.request.SignInKakaoRequest;
import com.depromeet.crackerbook.controller.user.dto.response.SignInKakaoResponse;
import com.depromeet.crackerbook.domain.user.User;
import com.depromeet.crackerbook.service.kakao.KakaoService;
import com.depromeet.crackerbook.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final KakaoService kakaoService;
    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/sign-in/kakao")
    public SignInKakaoResponse signInKakao(@RequestBody SignInKakaoRequest dto) {
        dto.validate();

        KakaoUserDto kakaoUserDto = kakaoService.kakaoLogin(dto);
        User user = userService.signInKakao(kakaoUserDto);

        String email = user.getEmail();
        userService.authenticate(email);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        String accessToken = userService.updateToken(user, userDetails);
        return SignInKakaoResponse.builder().accessToken(accessToken).build();
    }
}
