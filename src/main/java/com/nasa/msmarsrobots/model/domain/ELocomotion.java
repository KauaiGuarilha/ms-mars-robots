package com.nasa.msmarsrobots.model.domain;

import lombok.Getter;

@Getter
public enum ELocomotion {
    MOVE('M'),
    LEFT('L'),
    RIGHT('R');

    private final Character position;

    ELocomotion(Character position){
        this.position = position;
    }

    public static boolean valueOfPositionBoolean(Character position) {
        for (final ELocomotion locomotion : ELocomotion.values()) {
            if (locomotion.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
}
