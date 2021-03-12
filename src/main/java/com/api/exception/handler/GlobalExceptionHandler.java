package com.api.exception.handler;

import com.api.domain.exception.ErrorInfo;
import com.api.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorInfo handlerExceptionNotFound(HttpServletRequest request, Exception ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return buildErrorInfo(request, ex, Collections.singletonList(ex.getMessage()), httpStatus.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public @ResponseBody ErrorInfo handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {

        final List<String> messages = new ArrayList<>();
        ofNullable(ex.getBindingResult().getAllErrors())
                .orElse(emptyList())
                .forEach(objectError -> messages.add(buildMethodArgumentNotValidExceptionErrors(objectError)));

        return buildErrorInfo(request, ex, messages);
    }
}
