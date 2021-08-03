package com.exercises.vehicles.register.service;

import com.exercises.vehicles.register.model.Vehicle;
import com.exercises.vehicles.register.model.VehiclesDescription;
import com.exercises.vehicles.register.repository.VehicleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Instant;
import java.time.ZoneId;
import java.util.*;

@Service
public class VehiclesService {

    private final ObjectMapper objectMapper;

    private final VehicleRepository vehicleRepository;

    private final static int ONE_WEEK = 604800;

    public VehiclesService(@Autowired VehicleRepository vehicleRepository,
                           @Autowired ObjectMapper objectMapper) {
        this.vehicleRepository = vehicleRepository;
        this.objectMapper = objectMapper;
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findById(final String placa) {
        return vehicleRepository.findById(placa);
    }

    public List<Vehicle> findAllAndFilterByField(final String field, final String value) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            if (field.equals("placa") && vehicle.getAno() == Integer.getInteger(value) ||
                    field.equals("marca") && vehicle.getAno() == Integer.getInteger(value) ||
                    field.equals("ano") && vehicle.getAno() == Integer.getInteger(value) ||
                    field.equals("veiculo") && vehicle.getAno() == Integer.getInteger(value)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public VehiclesDescription getVehiclesDescription() {
        int notSold = 0;
        Map<String, Integer> decadeDistribution = new HashMap<>();
        Map<String, Integer> marcaDistribution = new HashMap<>();
        List<Vehicle> lastWeek = new ArrayList<>();
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            if (vehicle.isVendido()) {
                notSold++;
            }
            updateDistribution(decadeDistribution, getDecade(vehicle.getCreated()));
            updateDistribution(marcaDistribution, vehicle.getMarca());
            if (vehicle.getUpdated()
                    .toInstant()
                    .isAfter(Date.from(Instant.now()).toInstant().minusSeconds(ONE_WEEK))) {
                lastWeek.add(vehicle);
            }
        }
        return new VehiclesDescription(notSold, decadeDistribution, marcaDistribution, lastWeek);
    }

    private void updateDistribution(final Map<String, Integer> distribution, final String key) {
        Integer quantity = distribution.get(key);
        if (quantity == null) {
            distribution.put(key, 1);
        } else {
            distribution.replace(key, quantity + 1);
        }
    }

    private String getDecade(final Date date) {
        final String year = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() + "";
        return year.substring(0, year.length() - 1) + "0";

    }

    public void save(final Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public void updateFields(final Vehicle originalVehicle, final Vehicle newVehicleFields) {
        try {
            vehicleRepository.save(
                    objectMapper
                            .readerForUpdating(originalVehicle)
                            .readValue(objectMapper.writeValueAsString(newVehicleFields)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delete(final String placa) {
        vehicleRepository.deleteById(placa);
    }

}
