package com.nasa.msmarsrobots.model.domain;

import com.nasa.msmarsrobots.model.domain.interfaces.IEnumLabel;
import lombok.Getter;

@Getter
public enum EValidation implements IEnumLabel<EValidation> {
    POSITION_NOT_FOUND(1),
    COMMAND_INVALID(2),
    OUTSIDE_AREA(3),
    NOT_IDENTIFIED(-999);

    private final Integer code;

    EValidation(Integer code) {
        this.code = code;
    }
}
