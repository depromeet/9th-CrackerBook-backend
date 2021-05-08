package com.depromeet.crackerbook.feign;

import com.depromeet.crackerbook.controller.user.dto.KakaoTokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakao-auth-client", url = "https://kauth.kakao.com")
public interface KakaoAuthClient {

    @PostMapping("/oauth/token")
    KakaoTokenDto getKakaoToken(@RequestParam("grant_type") String grantType
            , @RequestParam("client_id") String clientId
            , @RequestParam("redirect_uri") String redirectUri
            , @RequestParam("code") String code);
}
