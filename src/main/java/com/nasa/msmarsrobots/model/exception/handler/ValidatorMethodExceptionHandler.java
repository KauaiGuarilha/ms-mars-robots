package com.nasa.msmarsrobots.model.exception.handler;

import com.nasa.msmarsrobots.model.domain.EValidation;
import com.nasa.msmarsrobots.model.dto.error.ErrorDTO;
import com.nasa.msmarsrobots.model.dto.error.ErrorsDTO;
import com.nasa.msmarsrobots.model.exception.ExceptionAbstract;
import com.nasa.msmarsrobots.model.exception.InvalidPositionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ValidatorMethodExceptionHandler {

    @ExceptionHandler(InvalidPositionException.class)
    public ResponseEntity<?> handlerInvalidPositionException(
            InvalidPositionException invalidPositionException) {

        log.error("Locomotion not found for position. ", invalidPositionException);
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code(EValidation.POSITION_NOT_FOUND.getCode())
                .message(invalidPositionException.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}