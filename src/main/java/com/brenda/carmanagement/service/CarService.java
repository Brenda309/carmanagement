package com.brenda.carmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.brenda.carmanagement.model.Car;

@Service
public class CarService {

    private final Map<Long, Car> cars = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Car createCar(String brand, String model, int year) {
        Car car = new Car();
        car.setId(idGenerator.getAndIncrement());
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);

        cars.put(car.getId(), car);
        return car;
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars.values());
    }

    public Car getCarById(Long id) {
        Car car = cars.get(id);
        if (car == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
        }
        return car;
    }
}