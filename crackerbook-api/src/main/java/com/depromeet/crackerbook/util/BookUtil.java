package com.depromeet.crackerbook.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class BookUtil {
    public static final String BASE_XLarge_IMAGE_URL_FORMAT = "http://image.kyobobook.co.kr/images/book/xlarge/%s/x%s.jpg";
    public static final String BASE_Large_IMAGE_URL_FORMAT = "http://image.kyobobook.co.kr/images/book/large/%s/l%s.jpg";

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

    public static boolean checkValidImage(String url) {
        boolean isValid = false;

        try {
            URL imageUrl = new URL(url);

            HttpURLConnection con = (HttpURLConnection) imageUrl.openConnection();
            con.setRequestMethod("GET");

            System.out.println(con.getResponseCode());

            if(con.getResponseCode() == 200)
                isValid = true;

        }catch(MalformedURLException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isValid;
    }

    public static String getImageUrlBig(String isbn){
        // ISBN 13이 없으면 해당 이미지 사진을 가져올 수 없음
        String isbnLong = getIsbnLong(isbn);
        if(isbnLong == null) return null;

        String lastPart = StringUtils.right(isbnLong,3);

        String xlargeUrl = String.format(BASE_XLarge_IMAGE_URL_FORMAT, lastPart, isbnLong);
        String largeUrl = String.format(BASE_Large_IMAGE_URL_FORMAT, lastPart, isbnLong);

        if(checkValidImage(xlargeUrl)) return xlargeUrl;
        if(checkValidImage(largeUrl)) return largeUrl;

        return null;
    }
}
