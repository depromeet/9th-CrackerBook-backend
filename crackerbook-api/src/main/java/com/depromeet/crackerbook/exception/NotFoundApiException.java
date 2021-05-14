package com.depromeet.crackerbook.exception;

import com.depromeet.crackerbook.common.ErrorCode;

public class NotFoundApiException extends RuntimeException {

    public NotFoundApiException(ErrorCode errorCode) {
        super(errorCode.name());
    }
}
