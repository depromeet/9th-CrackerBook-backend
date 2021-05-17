package com.depromeet.crackerbook.controller.book;

import com.depromeet.crackerbook.controller.SuccessResponse;
import com.depromeet.crackerbook.controller.book.dto.BookSearchDto;
import com.depromeet.crackerbook.controller.book.dto.response.BookSearchResponse;
import com.depromeet.crackerbook.controller.book.dto.response.kakao.KakaoBookDto;
import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.service.book.BookService;
import com.depromeet.crackerbook.service.kakao.KakaoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    private final KakaoService kakaoService;

    @Operation(summary = "스터디 개설 시 책 이름으로 조회")
    @GetMapping(value="", params="name")
    public SuccessResponse<BookSearchResponse> searchByName(@RequestParam("name") String name){

        List<Book> searchResult = bookService.searchByName(name);
        var response = searchResult.stream().map(entity -> BookSearchDto.from(entity)).collect(Collectors.toList());
//        if(!searchResult.isEmpty()){
//            var response =
//        }



        return name;
    }

    @Operation(summary = "스터디 개설 시 책 저자로 조회")
    @GetMapping(value="", params="author")
    public String searchByAuthor(@RequestParam("author") String author){

        return author;
    }

    @Operation(summary = "책 상세 조회")
    @GetMapping("/{bookId}")
    public Long getBookInfo(@PathVariable Long bookId){
        return bookId;
    }

    @Operation(summary = "책 검색")
    @GetMapping(value="", params={ "keyword", "type" })
    public String searchBook(
            @RequestParam("keyword") String keyword,
            @RequestParam("type") String type
    ){
        return keyword+" "+type;
    }
}
