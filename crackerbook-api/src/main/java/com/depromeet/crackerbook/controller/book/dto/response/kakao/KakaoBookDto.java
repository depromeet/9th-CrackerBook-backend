package com.depromeet.crackerbook.controller.book.dto.response.kakao;

import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.util.BookUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.apache.commons.text.StringEscapeUtils;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class KakaoBookDto {
    private String title;
    private String contents;

    private String url;

    private String isbn;

    private List<String> authors;

    private String publisher;

    private String datetime;

    private int price;

    private int salePrice;

    private String thumbnail;

    public String getImageUrlBig(){
        return BookUtil.getImageUrlBig(isbn);
    }

    public String getTitle(){ return escapeString(title); }

    public String getContent(){ return escapeString(contents); }

    public String getIsbnShort(){
        return BookUtil.getIsbnShort(isbn);
    }

    public String getIsbnLong(){
        return BookUtil.getIsbnLong(isbn);
    }

    public String getAuthors(){
        String author = authors.stream().collect(Collectors.joining(","));
        return escapeString(author);
    }

    public LocalDateTime getPublishedAt(){
        return LocalDateTime.parse(datetime, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("Asia/Seoul")));
    }

    public String getPublisher(){ return escapeString(publisher); }

    public Book toBook() {
        return Book.builder(
            getTitle()
            ,getContent()
            ,getIsbnShort()
            ,getIsbnLong()
            ,getAuthors()
            ,price
            ,salePrice
            ,thumbnail
            ,getImageUrlBig()
            ,getPublisher()
            ,getPublishedAt()
        ).build();
    }

    private String escapeString(String input){
        return StringEscapeUtils.unescapeHtml4(input); // escaping 되지 않은 HTML 처리
    }
}
