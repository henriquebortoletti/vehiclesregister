package com.exercises.vehicles.register.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class VehiclesDescription {

    private int naoVendidos;

    private Map<String, Integer> distribuicaoPorDecada;

    private Map<String, Integer> distribuicaoPorMarca;

    private List<Vehicle> veiculosUltimaSemana;

}
