package com.exercises.vehicles.register.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity
public class Vehicle {

    @Id
    private String placa;

    private String veiculo;

    private String marca;

    private boolean vendido;

    private int ano;

    private String descricao;

    private Date created;

    private Date updated;

}
