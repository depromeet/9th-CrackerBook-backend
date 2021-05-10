package com.depromeet.crackerbook.feign;

import com.depromeet.crackerbook.controller.user.dto.KakaoUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "kakao-api-client", url = "https://kapi.kakao.com")
public interface KakaoApiClient {

    @GetMapping("/v2/user/me")
    KakaoUserDto getKakaoUser(@RequestHeader("Authorization") String accessToken);
}
