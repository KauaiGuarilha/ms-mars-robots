package com.nasa.msmarsrobots.model.domain.interfaces;

import com.nasa.msmarsrobots.utils.MessageUtils;

public interface IEnumLabel<E extends Enum<E>> {

    default String getDescription() {
        return MessageUtils.getEnumLabel(this);
    }

    default String getDescription(String[] message) {
        return MessageUtils.getEnumLabel(this, message);
    }
}
