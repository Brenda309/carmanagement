package com.brenda.carmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brenda.carmanagement.dto.AddFuelRequest;
import com.brenda.carmanagement.dto.CreateCarRequest;
import com.brenda.carmanagement.dto.FuelStatsResponse;
import com.brenda.carmanagement.model.Car;
import com.brenda.carmanagement.model.FuelEntry;
import com.brenda.carmanagement.service.CarService;


import com.brenda.carmanagement.dto.AddFuelRequest;



@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car createCar(@RequestBody CreateCarRequest request) {
        return carService.createCar(
                request.getBrand(),
                request.getModel(),
                request.getYear()
        );
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @PostMapping("/{id}/fuel")
public void addFuel(
        @PathVariable Long id,
        @RequestBody AddFuelRequest request
) {
    FuelEntry entry = new FuelEntry();
    entry.setLiters(request.getLiters());
    entry.setPrice(request.getPrice());
    entry.setOdometer(request.getOdometer());

    carService.addFuel(id, entry);
}
@GetMapping("/{id}/fuel/stats")
public FuelStatsResponse getFuelStats(@PathVariable Long id) {
    return carService.getFuelStats(id);
}
}