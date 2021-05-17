package com.depromeet.crackerbook.controller.book.dto.response.kakao;

import com.depromeet.crackerbook.domain.book.Book;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Getter
@ToString
public class KakaoBookDto {
    private Long id;

    private String title;
    private String contents;
    private String url;
    private String isbn; // 공백으로 구분
    private String isbnShort;
    private String isbnLong;
    private String[] authors;
    private String author;
    private String publisher;
    private String[] translators; // 필요할까..?
    private String datetime;
    private int price;
    private int sale_price;
    private String thumbnail;
    private String imageUrlBig;
    private String status;

    private void splitIsbn(String isbn){
        String[] isbns = isbn.split(" ");
        this.isbnShort = isbns[0];
        if(isbns.length == 2){
            this.isbnLong = isbns[1];
        }
    }

    private void combineAuthor(){
        this.author = Arrays.toString(authors);
    }

    //  .authors((String) ((List) bookInfo.get(KAKAO_API_JSON_KEY_DOCS_AUTHORS)).stream().collect(Collectors.joining(",")))
    private void makeBigImageUrl(){
        // http://image.kyobobook.co.kr/images/book/xlarge
        if(isbnLong == null) return;
        int len = this.isbnLong.length();
        String part = this.isbnLong.substring(len-3, len);
        String imageUrl = String.format("http://image.kyobobook.co.kr/images/book/xlarge/%s/x%s.jpg", part, this.isbnLong);
        this.imageUrlBig = imageUrl;
    }

    private void initialize(){
        this.splitIsbn(this.isbn);
        this.combineAuthor();
        this.makeBigImageUrl();
    }

    public Book toEntity() {
        this.initialize();
        return Book.builder()
                .name(title)
                .contents(contents)
                .isbnShort(isbnShort)
                .isbnLong(isbnLong)
                .authors(author)
                .price(price)
                .salePrice(sale_price)
                .imageUrlSmall(thumbnail)
                .imageUrlBig(imageUrlBig)
                .publisher(publisher)
                .publishedAt(LocalDateTime.parse(datetime, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("Asia/Seoul"))))
                .build();
    }
}
