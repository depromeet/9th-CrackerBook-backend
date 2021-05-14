package com.depromeet.crackerbook.exception;

import com.depromeet.crackerbook.common.ErrorCode;

public class BadRequestApiException extends RuntimeException {

    public BadRequestApiException(ErrorCode errorCode) {
        super(errorCode.name());
    }
}
