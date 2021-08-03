package com.exercises.vehicles.register.controller;

import com.exercises.vehicles.register.service.MultiplesService;
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
@RequestMapping("/multiples")
@Api(tags = {"Soma dos múltiplos de 3 e 5 do path param"})
@SwaggerDefinition(tags = {
        @Tag(name = "Soma dos múltiplos de 3 e 5 do path param",
                description = "Essa API é responsável por retornar a soma dos múltiplos de 3 e 5 do path param")
})
public class MultiplesController {

    private MultiplesService multiplesService;

    public MultiplesController(@Autowired MultiplesService multiplesService) {
        this.multiplesService = multiplesService;
    }

    @GetMapping(value = "/sum/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int factorial(@PathVariable int value) {
        return multiplesService.multiplesSum(value);
    }
}
