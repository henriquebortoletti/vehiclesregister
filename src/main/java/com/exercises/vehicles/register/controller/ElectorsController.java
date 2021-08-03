package com.exercises.vehicles.register.controller;


import com.exercises.vehicles.register.model.Electors;
import com.exercises.vehicles.register.service.ElectorsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/electors")
@Api(tags = {"Percentual de votos dos eleitores"})
@SwaggerDefinition(tags = {
        @Tag(name = "Percentual de votos dos eleitores",
                description = "Essa API é responsável por retornar o percentual de votos dos eleitores")
})
public class ElectorsController {

    private final ElectorsService electorsService;

    public ElectorsController(@Autowired final ElectorsService electorsService) {
        this.electorsService = electorsService;
    }


    @GetMapping(value = "/votes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Electors electors() {
        return electorsService.getElectors();
    }
}
