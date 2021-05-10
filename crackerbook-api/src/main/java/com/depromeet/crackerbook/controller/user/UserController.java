package com.depromeet.crackerbook.controller.user;

import com.depromeet.crackerbook.controller.user.dto.KakaoTokenDto;
import com.depromeet.crackerbook.controller.user.dto.KakaoUserDto;
import com.depromeet.crackerbook.controller.user.dto.request.SignInKakaoRequest;
import com.depromeet.crackerbook.controller.user.dto.response.SignInKakaoResponse;
import com.depromeet.crackerbook.service.kakao.KakaoService;
import com.depromeet.crackerbook.service.user.UserService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/signIn/kakao")
    public SignInKakaoResponse signInKakao(@RequestBody SignInKakaoRequest dto) {
        dto.validate();

        KakaoTokenDto kakaoToken = kakaoService.getKakaoToken(dto);
        KakaoUserDto kakaoUserDto = kakaoService.getKakaoUser(kakaoToken.getAccess_token());
        userService.signInKakao(kakaoUserDto);

        return SignInKakaoResponse.builder("sample", "sample").build();
    }
}
