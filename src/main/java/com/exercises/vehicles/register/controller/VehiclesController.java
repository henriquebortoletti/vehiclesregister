package com.exercises.vehicles.register.controller;

import com.exercises.vehicles.register.model.Vehicle;
import com.exercises.vehicles.register.model.VehiclesDescription;
import com.exercises.vehicles.register.service.VehiclesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
@Api(tags = {"APIs responsáveis pelo registro de veículos"})
@SwaggerDefinition(tags = {
        @Tag(name = "APIs responsáveis pelo registro de veículos",
                description = "Essas APIs são responsáveis por registrar e retornar informações sobre os veículos salvos")
})
public class VehiclesController {

    private VehiclesService vehiclesService;

    private List<String> validMarcas;

    public VehiclesController(@Autowired VehiclesService vehiclesService,
                              @Value("${marcas}") List<String> validMarcas) {
        this.vehiclesService = vehiclesService;
        this.validMarcas = validMarcas;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vehicle>> findAll(@RequestParam(required = false, name = "q") String field,
                                 @RequestParam(required = false) String fieldValue) {
        if (field == null && fieldValue == null) {
            return ResponseEntity.ok(vehiclesService.findAll());
        } else if (field != null && fieldValue != null) {
            return ResponseEntity.ok(vehiclesService.findAllAndFilterByField(field, fieldValue));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/descricao", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehiclesDescription description() {
        return vehiclesService.getVehiclesDescription();
    }

    @GetMapping(value = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> findById(@PathVariable String placa) {
        Vehicle originalVehicle = vehiclesService.findById(placa).orElse(null);
        if (originalVehicle != null) {
            return ResponseEntity.ok(originalVehicle);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@RequestBody Vehicle vehicle) {
        if (validMarcas.contains(vehicle.getMarca().toLowerCase())) {
            if(!vehiclesService.findById(vehicle.getPlaca()).isPresent()){
                vehiclesService.save(vehicle);
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{placa}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable String placa, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> originalVehicle = vehiclesService.findById(placa);
        if (originalVehicle.isPresent()) {
            vehiclesService.save(vehicle);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "/{placa}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateFields(@PathVariable String placa, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> originalVehicle = vehiclesService.findById(placa);
        if (originalVehicle.isPresent()) {
            vehiclesService.updateFields(originalVehicle.get(), vehicle);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable String placa) {
        Optional<Vehicle> originalVehicle = vehiclesService.findById(placa);
        if (originalVehicle.isPresent()) {
            vehiclesService.delete(placa);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
