package com.depromeet.crackerbook.controller.book;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.controller.SuccessResponse;
import com.depromeet.crackerbook.controller.book.dto.response.BookSearchResponse;
import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import com.depromeet.crackerbook.exception.NotFoundApiException;
import com.depromeet.crackerbook.service.book.BookService;
import com.depromeet.crackerbook.service.kakao.KakaoService;
import io.jsonwebtoken.lang.Collections;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final KakaoService kakaoService;
    private final BookService bookService;

    @Operation(summary = "스터디 개설 시 책 이름으로 조회")
    @GetMapping(params="name")
    public SuccessResponse<BookSearchResponse> searchByName(
        @RequestParam String name,
        @Parameter(description = "페이지", required = true) @RequestParam int page,
        @Parameter(description = "개수", required = true) @RequestParam int size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        List<KakaoBookDto> kakaoResults = kakaoService.searchKakaoBookByTitle(name, pageRequest);

        if(CollectionUtils.isEmpty(kakaoResults)){
            throw new NotFoundApiException(ErrorCode.INVALID_BOOK_NAME_KEYWORD);
        }

        List<BookSearchDto> bookResults = bookService.findOrSaveBooks(kakaoResults);

        var response = BookSearchResponse.from(bookResults);
        return new SuccessResponse<>(response);
    }

    @Operation(summary = "스터디 개설 시 책 저자로 조회")
    @GetMapping(params="author")
    public SuccessResponse<BookSearchResponse> searchByAuthor(
        @RequestParam("author") String author,
        @Parameter(description = "페이지", required = true) @RequestParam int page,
        @Parameter(description = "개수", required = true) @RequestParam int size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        List<KakaoBookDto> kakaoResults = kakaoService.searchKakaoBookByAuthor(author, pageRequest);

        if(Collections.isEmpty(kakaoResults)){
            throw new NotFoundApiException(ErrorCode.INVALID_BOOK_AUTHOR_KEYWORD);
        }

        List<BookSearchDto> bookResults = bookService.findOrSaveBooks(kakaoResults);

        var response = BookSearchResponse.from(bookResults);
        return new SuccessResponse<>(response);
    }

    @Operation(summary = "책 상세 조회")
    @GetMapping("/{bookId}")
    public Long getBookInfo(@PathVariable Long bookId){
        return bookId;
    }
}
