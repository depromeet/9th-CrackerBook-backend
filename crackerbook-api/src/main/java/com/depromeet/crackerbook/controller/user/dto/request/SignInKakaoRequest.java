package com.depromeet.crackerbook.controller.user.dto.request;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.exception.ApiException;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class SignInKakaoRequest {

    private String code;

    public void validate() {
        if (StringUtils.isEmpty(code)) {
            throw new ApiException(ErrorCode.REQUIRED_KAKAO_CODE);
        }
    }
}
