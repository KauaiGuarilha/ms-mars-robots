package com.nasa.msmarsrobots.model.exception;

import com.nasa.msmarsrobots.model.domain.EValidation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceNotFoundException extends ExceptionAbstract {

    public ResourceNotFoundException(EValidation validation, String... params) {
        super(validation, params);
    }
}
