package com.api.exception.handler;

import com.api.domain.exception.ErrorInfo;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;

public abstract class BaseExceptionHandler {
    public static final String REQUEST_ERROR_MSG_PATTERN = "{ object: %s, field: %s, message: %s }";

    public ErrorInfo buildErrorInfo(
            HttpServletRequest request,
            Exception exception,
            List<String> messages,
            Integer status
    ) {
        return ErrorInfo.builder().timestamp(LocalDateTime.now())
                .messages(messages)
                .exception(exception.getClass().getSimpleName())
                .path(request.getRequestURI())
                .code(status)
                .build();
    }

    public ErrorInfo buildErrorInfo(HttpServletRequest request, Exception exception, List<String> messages) {
        return ErrorInfo.builder().timestamp(LocalDateTime.now())
                .messages(messages)
                .exception(exception.getClass().getSimpleName())
                .path(request.getRequestURI())
                .build();
    }

    public static String buildMethodArgumentNotValidExceptionErrors(ObjectError objectError) {

        final String defaultMessage = objectError.getDefaultMessage();
        if (objectError instanceof FieldError) {
            final FieldError field = (FieldError) objectError;

            return format(REQUEST_ERROR_MSG_PATTERN, field.getObjectName(), field.getField(), defaultMessage);
        }

        if(!defaultMessage.isEmpty()) {
            return defaultMessage;
        }

        return format(REQUEST_ERROR_MSG_PATTERN, objectError.getObjectName(), objectError.getArguments(), objectError.getCodes());
    }
}
