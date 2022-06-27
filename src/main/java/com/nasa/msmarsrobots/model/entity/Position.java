package com.nasa.msmarsrobots.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private int distance;

    public int getXPosition(Character character, int value){
        if (character.equals('E')) return value + 1;

        if (character.equals('W')) return value - 1;

        return value;
    }

    public int getYPosition(Character character, int value){
        if (character.equals('N')) return value + 1;

        if (character.equals('S')) return value - 1;

        return value;
    }
}
