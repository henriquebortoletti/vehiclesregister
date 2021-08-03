package com.exercises.vehicles.register.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplesService {

    public int multiplesSum(int value) {
        int sum = 0;
        for (int i = 1; i < value; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

}
