package com.depromeet.crackerbook.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class BookUtil {
    public static final String BASE_X_LARGE_IMAGE_URL_FORMAT = "http://image.kyobobook.co.kr/images/book/xlarge/%s/x%s.jpg";
    public static final String BASE_LARGE_IMAGE_URL_FORMAT = "http://image.kyobobook.co.kr/images/book/large/%s/l%s.jpg";

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

            if(con.getResponseCode() == 200){
                isValid = true;
            }

        }catch(MalformedURLException me) {
            me.printStackTrace();
        }catch(IOException ie) {
            ie.printStackTrace();
        }

        return isValid;
    }

    private String getXLargeImageUrl(String isbn, String lastPart){
        String url =  String.format(BASE_X_LARGE_IMAGE_URL_FORMAT, lastPart, isbn);
        if(checkValidImage(url)) return url;
        return getLargeImageUrl(isbn, lastPart);
    }

    private String getLargeImageUrl(String isbn, String lastPart){
        String url = String.format(BASE_LARGE_IMAGE_URL_FORMAT, lastPart, isbn);
        if(checkValidImage(url)) return url;
        return null;
    }

    public static String getImageUrlBig(String isbn) {
        // ISBN 13??? ????????? ?????? ????????? ????????? ????????? ??? ??????
        String isbnLong = getIsbnLong(isbn);
        if(isbnLong == null) return null;

        String lastPart = StringUtils.right(isbnLong, 3);

        return getXLargeImageUrl(isbn, lastPart);
    }
}
