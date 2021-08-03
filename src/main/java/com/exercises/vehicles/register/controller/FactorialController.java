package com.exercises.vehicles.register.controller;

import com.exercises.vehicles.register.service.FactorialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factorial")
@Api(tags = {"Fatorial do path param"})
@SwaggerDefinition(tags = {
        @Tag(name = "Fatorial do path param",
                description = "Essa API é responsável por retornar o fatorial do valor passado como parametro")
})
public class FactorialController {

    private FactorialService factorialService;

    public FactorialController(@Autowired FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @GetMapping(value = "/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int factorial(@PathVariable int value) {
        return factorialService.factorial(value);
    }
}
