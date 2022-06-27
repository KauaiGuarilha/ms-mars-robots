package com.nasa.msmarsrobots.model.exception.handler;

import com.nasa.msmarsrobots.model.domain.EValidation;
import com.nasa.msmarsrobots.model.dto.error.ErrorDTO;
import com.nasa.msmarsrobots.model.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(
            ResourceNotFoundException resourceNotFoundException) {

        log.error("Resource not Found. ", resourceNotFoundException);
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code(EValidation.NOT_IDENTIFIED.getCode())
                .message(resourceNotFoundException.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException httpMessageNotReadableException,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        log.error("Resource not Found. ", httpMessageNotReadableException);
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code(EValidation.NOT_IDENTIFIED.getCode())
                .message(httpMessageNotReadableException.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            @Nullable Object body,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        log.error("Generic error in request processing", ex);
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code(EValidation.NOT_IDENTIFIED.getCode())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, headers, HttpStatus.BAD_REQUEST);
    }
}
