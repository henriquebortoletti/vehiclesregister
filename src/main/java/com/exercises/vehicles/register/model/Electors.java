package com.exercises.vehicles.register.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Electors {

    private int totalElectors;

    private String validVotesPercentage;

    private String whiteVotesPercentage;

    private String nullVotesPercentage;
}
