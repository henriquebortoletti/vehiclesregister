package com.exercises.vehicles.register.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {

    public int factorial(final int value) {
        int product = 1;
        for (int i = value; i > 0; i--) {
            product *= i;
        }
        return product;
    }
}
