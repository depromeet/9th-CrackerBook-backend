package com.depromeet.crackerbook.controller.book.dto.response.kakao;

import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.util.BookUtil;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
public class KakaoBookDto{
    private String title;
    private String contents;

    private String url;

    private String isbn;

    private List<String> authors;

    private String publisher;

    private String datetime;

    private int price;
    private int sale_price;

    private String thumbnail;

    public String getImageUrlBig(){
        return BookUtil.getImageUrlBig(isbn);
    }

    public String getIsbnShort(){
        return BookUtil.getIsbnShort(isbn);
    }

    public String getIsbnLong(){
        return BookUtil.getIsbnLong(isbn);
    }

    public Book toEntity() {
        return Book.builder(
            title
            ,contents
            ,getIsbnShort()
            ,getIsbnLong()
            ,authors.stream().collect(Collectors.joining(","))
            ,price
            ,sale_price
            ,thumbnail
            ,getImageUrlBig()
            ,publisher
            ,LocalDateTime.parse(datetime, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("Asia/Seoul")))
        ).build();
    }
}
