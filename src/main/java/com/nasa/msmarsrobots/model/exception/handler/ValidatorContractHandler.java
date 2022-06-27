package com.nasa.msmarsrobots.model.exception.handler;

import com.nasa.msmarsrobots.model.dto.error.ErrorDTO;
import com.nasa.msmarsrobots.model.dto.error.ErrorsDTO;
import com.nasa.msmarsrobots.model.exception.ExceptionAbstract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class ValidatorContractHandler {

    @ExceptionHandler(ExceptionAbstract.class)
    protected ResponseEntity<Object> validatorHandle(ExceptionAbstract exception) {
        List<ErrorDTO> errors = new ArrayList<>();

        if (Objects.isNull(exception.getMsgs()) || exception.getMsgs().size() == 0) {
            errors.add(ErrorDTO.builder().code(exception.getCode()).message(exception.getMessage()).build());
        } else {
            exception.getMsgs().forEach(m -> errors.add(
                    ErrorDTO.builder()
                            .code(exception.getCode())
                            .message(m)
                            .build()));
        }

        return new ResponseEntity<>(
                ErrorsDTO.builder().errors(errors).build(), HttpStatus.BAD_REQUEST);
    }
}
