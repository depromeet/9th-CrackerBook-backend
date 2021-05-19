package com.depromeet.crackerbook.controller.book.dto.response.kakao;

import com.depromeet.crackerbook.domain.book.Book;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.StringUtils;

@Getter
@ToString
public class KakaoBookDto{
    private String title;
    private String contents;

    private String url;

    private String isbn;
    private String isbnShort;
    private String isbnLong;

    private List<String> authors;
    private String author;

    private String publisher;

//    private String[] translators; // 필요할까..?

    private String datetime;
    private int price;
    private int sale_price;
    private String thumbnail;
    private String imageUrlBig;
    private String status;

    private void splitIsbn(String isbn){
        String[] isbns = isbn.split(" ");
        if(isbns.length == 2){
            this.isbnShort = isbns[0];
            this.isbnLong = isbns[1];
        }else{
            if(isbns[0].length() == 13) this.isbnLong = isbns[0];
            else this.isbnShort = isbns[0];
        }
    }


    private void makeBigImageUrl(){
        // http://image.kyobobook.co.kr/images/book/xlarge
        if(isbnLong == null) return;
        String imageUrl = String.format("http://image.kyobobook.co.kr/images/book/xlarge/%s/x%s.jpg", StringUtils.right(this.isbnLong,3), this.isbnLong);
        this.imageUrlBig = imageUrl;
    }

    private void initialize(){
        this.splitIsbn(this.isbn);
        this.makeBigImageUrl();
    }

    public Book toEntity() {
        this.initialize();
        return Book.builder()
                .name(title)
                .contents(contents)
                .isbnShort(isbnShort)
                .isbnLong(isbnLong)
                .authors(authors.stream().collect(Collectors.joining(",")))
                .price(price)
                .salePrice(sale_price)
                .imageUrlSmall(thumbnail)
                .imageUrlBig(imageUrlBig)
                .publisher(publisher)
                .publishedAt(LocalDateTime.parse(datetime, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of("Asia/Seoul"))))
                .build();
    }
}
