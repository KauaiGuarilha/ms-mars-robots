package com.nasa.msmarsrobots.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutputDTO {
    private int x;
    private int y;
    private Character orientation;

    @Override
    public String toString() {
        return "(" + x + ", " +  y + ", " + orientation + ")";
    }
}
