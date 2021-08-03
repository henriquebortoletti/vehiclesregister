package com.exercises.vehicles.register.service;

import com.exercises.vehicles.register.model.VectorOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BubbleSortService {

    @Value("${vector.original}")
    private int[] originalVector;

    public VectorOrder order() {
        int[] orderedVector = Arrays.copyOf(originalVector, originalVector.length);
        for (int i = orderedVector.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (orderedVector[j - 1] > orderedVector[j]) {
                    int actual = orderedVector[j];
                    orderedVector[j] = orderedVector[j - 1];
                    orderedVector[j - 1] = actual;
                }
            }
        }

        return new VectorOrder(originalVector, orderedVector);
    }
}


