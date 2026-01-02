package com.brenda.carmanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brenda.carmanagement.model.Car;
import com.brenda.carmanagement.service.CarService;

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
}