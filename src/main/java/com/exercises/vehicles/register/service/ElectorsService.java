package com.exercises.vehicles.register.service;

import com.exercises.vehicles.register.model.Electors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class ElectorsService {

    @Value("${electors.total}")
    private int totalElectors;

    @Value("${electors.votes.valid}")
    private double validVotes;

    @Value("${electors.votes.white}")
    private double whiteVotes;

    @Value("${electors.votes.nul}")
    private double nullVotes;

    public Electors getElectors() {
        return new Electors(totalElectors, validVotesPercentage(), whiteVotesPercentage(), nullVotesPercentage());
    }

    private String validVotesPercentage() {
        return normalizePercentage(validVotes / totalElectors);
    }

    private String whiteVotesPercentage() {
        return normalizePercentage(whiteVotes / totalElectors);
    }

    private String nullVotesPercentage() {
        return normalizePercentage(nullVotes / totalElectors);
    }

    private String normalizePercentage(final double divisionResult) {
        return  new DecimalFormat("##.##").format(divisionResult * 100) + "%";
    }
}
