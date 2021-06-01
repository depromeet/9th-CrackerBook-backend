package com.depromeet.crackerbook.service.kakao;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoSearchResponse;
import com.depromeet.crackerbook.controller.user.dto.KakaoTokenDto;
import com.depromeet.crackerbook.controller.user.dto.KakaoUserDto;
import com.depromeet.crackerbook.controller.user.dto.request.SignInKakaoRequest;
import com.depromeet.crackerbook.exception.BadRequestApiException;
import com.depromeet.crackerbook.feign.KakaoApiClient;
import com.depromeet.crackerbook.feign.KakaoAuthClient;
import com.depromeet.crackerbook.feign.KakaoBookClient;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class KakaoService {

    @Value("${kakao.client-id}")
    private String kakaoClientId;

    @Value("${kakao.redirect-uri}")
    private String kakaoRedirectUri;

    private static final String GRANT_TYPE = "authorization_code";

    private final KakaoAuthClient kakaoAuthClient;
    private final KakaoApiClient kakaoApiClient;
    private final KakaoBookClient kakaoBookClient;

    public KakaoUserDto kakaoLogin(SignInKakaoRequest dto, String frontendDomain) {
        KakaoTokenDto kakaoToken = getKakaoToken(dto, frontendDomain);
        return getKakaoUser(kakaoToken.getAccess_token());
    }

    private KakaoTokenDto getKakaoToken(SignInKakaoRequest dto, String frontendDomain) {
        String redirectUri = frontendDomain + kakaoRedirectUri;
        return kakaoAuthClient.getKakaoToken(GRANT_TYPE, kakaoClientId, redirectUri, dto.getCode());
    }

    private KakaoUserDto getKakaoUser(String accessToken) {
        if (StringUtils.isEmpty(accessToken)) {
            throw new BadRequestApiException(ErrorCode.REQUIRED_KAKAO_ACCESS_TOKEN);
        }
        return kakaoApiClient.getKakaoUser(String.format("Bearer %s", accessToken));
    }

    public List<KakaoBookDto> searchKakaoBookByTitle(String title){
        String clientId = String.format("KakaoAK %s", kakaoClientId);
        KakaoSearchResponse<KakaoBookDto> result = kakaoBookClient.searchBook(clientId,"title", title);
        return result.getDocuments();
    }

    public List<KakaoBookDto> searchKakaoBookByAuthor(String author){
        String clientId = String.format("KakaoAK %s", kakaoClientId);
        KakaoSearchResponse<KakaoBookDto> result = kakaoBookClient.searchBook(clientId,"person", author);
        return result.getDocuments();
    }
}
