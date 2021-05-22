package com.depromeet.crackerbook.feign;

import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "kakao-book-client", url = "https://dapi.kakao.com")
public interface KakaoBookClient {

    @GetMapping("/v3/search/book")
    KakaoSearchResponse<KakaoBookDto> searchBook(
            @RequestHeader("Authorization") String accessToken,
            @RequestParam("target") String target,
            @RequestParam("query") String query,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    );
}
