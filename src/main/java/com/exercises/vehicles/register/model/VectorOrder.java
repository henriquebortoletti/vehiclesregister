package com.exercises.vehicles.register.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class VectorOrder {

    private int[] originalVector;

    private int[] orderedVector;
}
