package com.nasa.msmarsrobots.model.exception;

import com.nasa.msmarsrobots.model.domain.EValidation;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class ExceptionAbstract extends RuntimeException {

    private List<String> msgs;
    private EValidation validation;
    @Getter private String[] params;

    public Integer getCode() {
        return this.validation.getCode();
    }

    public String getMessage() {
        return this.validation.getDescription(this.params);
    }

    public ExceptionAbstract(EValidation validation, String... params) {
        super(validation.getDescription());
        this.validation = validation;
        this.params = params;
    }
}
