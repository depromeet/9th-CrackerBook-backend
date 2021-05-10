package com.depromeet.crackerbook.exception;

import com.depromeet.crackerbook.common.ErrorCode;

public class ApiException extends RuntimeException {

    public ApiException(ErrorCode errorCode) {
        super(errorCode.name());
    }
}
