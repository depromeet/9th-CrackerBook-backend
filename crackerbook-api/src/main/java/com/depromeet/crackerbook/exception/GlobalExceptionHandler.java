package com.depromeet.crackerbook.exception;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.controller.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * javax.validation.Valid or @Validated 바인딩 에러 (@RequestBody, @RequestPart)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 바인딩 에러 (@ModelAttribute)
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("handleBindException", e);
        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * enum type 바인딩 에러 (@RequestParam)
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("handleMethodArgumentTypeMismatchException", e);
        final ErrorResponse response = ErrorResponse.of(e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 지원하지 않는 HTTP method 호출 에러
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * 400 에러
     */
    @ExceptionHandler(BadRequestApiException.class)
    public ResponseEntity<ErrorResponse> badRequestExceptionHandler(BadRequestApiException e) {
        ErrorCode errorCode = ErrorCode.valueOf(e.getMessage());
        return new ResponseEntity<>(ErrorResponse.of(errorCode), HttpStatus.BAD_REQUEST);
    }

    /**
     * 404 에러
     */
    @ExceptionHandler(NotFoundApiException.class)
    public ResponseEntity<ErrorResponse> notFoundApiExceptionHandler(NotFoundApiException e) {
        ErrorCode errorCode = ErrorCode.valueOf(e.getMessage());
        return new ResponseEntity<>(ErrorResponse.of(errorCode), HttpStatus.NOT_FOUND);
    }

    /**
     * 500 에러
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> apiExceptionHandler(ApiException e) {
        ErrorCode errorCode = ErrorCode.valueOf(e.getMessage());
        return new ResponseEntity<>(ErrorResponse.of(errorCode), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 예측되지 않은 에러
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.UNEXPECTED_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
