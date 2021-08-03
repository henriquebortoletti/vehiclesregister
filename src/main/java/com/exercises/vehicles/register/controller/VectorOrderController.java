package com.exercises.vehicles.register.controller;

import com.exercises.vehicles.register.model.VectorOrder;
import com.exercises.vehicles.register.service.BubbleSortService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vector")
@Api(tags = {"Ordenação dos vetores"})
@SwaggerDefinition(tags = {
        @Tag(name = "Ordenação dos vetores",
                description = "Essa API é responsável por ordenar e retornar o vetor salvo no application.yml")
})
public class VectorOrderController {

    private BubbleSortService bubbleSortService;

    public VectorOrderController(@Autowired final BubbleSortService bubbleSortService) {
        this.bubbleSortService = bubbleSortService;
    }

    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public VectorOrder vectorOrder() {
        return bubbleSortService.order();
    }
}
