package org.kmss.booking_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage name(ResourceNotFoundException exception, WebRequest webRequest) {
        var errorMessage = ErrorMessage.builder()
                .statusCode(404)
                .message("Resource not found")
                .build();
        return errorMessage;
    }
}
