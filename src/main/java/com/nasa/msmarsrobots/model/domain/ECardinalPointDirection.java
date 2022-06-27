package com.nasa.msmarsrobots.model.domain;

import lombok.Getter;

@Getter
public enum ECardinalPointDirection {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private final Character position;

    ECardinalPointDirection(Character position){
        this.position = position;
    }
}