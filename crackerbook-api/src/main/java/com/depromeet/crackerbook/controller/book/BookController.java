package com.depromeet.crackerbook.controller.book;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.controller.SuccessResponse;
import com.depromeet.crackerbook.controller.book.dto.response.BookSearchResponse;
import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import com.depromeet.crackerbook.exception.NotFoundApiException;
import com.depromeet.crackerbook.service.kakao.KakaoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final KakaoService kakaoService;

    @Operation(summary = "스터디 개설 시 책 이름으로 조회")
    @GetMapping(params="name")
    public SuccessResponse<BookSearchResponse> searchByName(@RequestParam("name") String name){

        List<KakaoBookDto> kakaoResults = kakaoService
            .searchKakaoBookByTitle(name)
            .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_BOOK_NAME_KEYWORD));

        var response = BookSearchResponse.from(kakaoResults);
        return new SuccessResponse<>(response);
    }

    @Operation(summary = "스터디 개설 시 책 저자로 조회")
    @GetMapping(params="author")
    public SuccessResponse<BookSearchResponse> searchByAuthor(@RequestParam("author") String author){
        List<KakaoBookDto> kakaoResults = kakaoService
            .searchKakaoBookByAuthor(author)
            .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_BOOK_AUTHOR_KEYWORD));

        var response = BookSearchResponse.from(kakaoResults);
        return new SuccessResponse<>(response);
    }

    @Operation(summary = "책 상세 조회")
    @GetMapping("/{bookId}")
    public Long getBookInfo(@PathVariable Long bookId){
        return bookId;
    }

    @Operation(summary = "책 검색")
    @GetMapping(params={ "keyword", "type" })
    public String searchBook(
            @RequestParam("keyword") String keyword,
            @RequestParam("type") String type
    ){
        return keyword+" "+type;
    }
}
