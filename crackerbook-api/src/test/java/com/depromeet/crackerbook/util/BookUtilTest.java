package com.depromeet.crackerbook.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookUtilTest {

    @Test
    public void checkValidImageTest(){
        String validImageUrl = "http://image.kyobobook.co.kr/images/book/xlarge/124/x9788985706124.jpg";
        String invalidImageUrl = "http://image.kyobobook.co.kr/images/book/large/414/l9788971990414.jpg";

        boolean isInvalid = BookUtil.checkValidImage(validImageUrl);
        boolean isValid = BookUtil.checkValidImage(invalidImageUrl);

        assertThat(isInvalid).isEqualTo(false);
        assertThat(isValid).isEqualTo(true);
    }
}
