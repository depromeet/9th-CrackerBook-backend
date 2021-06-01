package com.depromeet.crackerbook.util;

import org.apache.commons.lang3.StringUtils;

public class BookUtil {
    public static final String BASE_BIG_IMAGE_URL_FORMAT = "http://image.kyobobook.co.kr/images/book/xlarge/%s/x%s.jpg";

    public static final int ISBN_13 = 13;
    public static final int ISBN_10 = 10;

    private static String[] splitRawIsbn(String rawIsbn){
        return rawIsbn.split(" ");
    }

    public static String getIsbnShort(String isbn){
        String[] result = splitRawIsbn(isbn);
        if(StringUtils.isBlank(result[0])) return null;
        return result[0];
    }

    public static String getIsbnLong(String isbn){
        String[] result = splitRawIsbn(isbn);
        if(StringUtils.isBlank(result[1])) return null;
        return result[1];
    }

    public static String getImageUrlBig(String isbn){
        String isbnLong = getIsbnLong(isbn);
        if(isbnLong == null) return null;
        String lastPart = StringUtils.right(isbnLong,3);
        String imageUrl = String.format(BASE_BIG_IMAGE_URL_FORMAT, lastPart, isbnLong);
        return imageUrl;
    }
}
