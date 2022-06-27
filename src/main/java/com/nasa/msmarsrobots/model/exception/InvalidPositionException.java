package com.nasa.msmarsrobots.model.exception;

import com.nasa.msmarsrobots.model.domain.EValidation;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPositionException extends ExceptionAbstract {

    public InvalidPositionException(EValidation validation, String... params) {
        super(validation, params);
    }
}
