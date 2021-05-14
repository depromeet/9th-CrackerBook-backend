package com.depromeet.crackerbook.service.kakao;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.controller.user.dto.KakaoTokenDto;
import com.depromeet.crackerbook.controller.user.dto.KakaoUserDto;
import com.depromeet.crackerbook.controller.user.dto.request.SignInKakaoRequest;
import com.depromeet.crackerbook.exception.BadRequestApiException;
import com.depromeet.crackerbook.feign.KakaoApiClient;
import com.depromeet.crackerbook.feign.KakaoAuthClient;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KakaoService {

    @Value("${kakao.client-id}")
    private String kakaoClientId;

    @Value("${kakao.redirect-uri}")
    private String kakaoRedirectUri;

    @Value("${frontend.domain}")
    private String frontendDomain;

    private static final String GRANT_TYPE = "authorization_code";

    private final KakaoAuthClient kakaoAuthClient;
    private final KakaoApiClient kakaoApiClient;

    public KakaoUserDto kakaoLogin(SignInKakaoRequest dto) {
        KakaoTokenDto kakaoToken = getKakaoToken(dto);
        return getKakaoUser(kakaoToken.getAccess_token());
    }

    private KakaoTokenDto getKakaoToken(SignInKakaoRequest dto) {
        String redirectUri = frontendDomain + kakaoRedirectUri;
        return kakaoAuthClient.getKakaoToken(GRANT_TYPE, kakaoClientId, redirectUri, dto.getCode());
    }

    private KakaoUserDto getKakaoUser(String accessToken) {
        if (StringUtils.isEmpty(accessToken)) {
            throw new BadRequestApiException(ErrorCode.REQUIRED_KAKAO_ACCESS_TOKEN);
        }
        return kakaoApiClient.getKakaoUser(String.format("Bearer %s", accessToken));
    }
}
