package com.brenda.carmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.brenda.carmanagement.dto.FuelStatsResponse;
import com.brenda.carmanagement.model.Car;
import com.brenda.carmanagement.model.FuelEntry;
import com.brenda.carmanagement.model.FuelEntry;

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
    public void addFuel(Long carId, FuelEntry fuelEntry) {
    Car car = getCarById(carId); // reuse existing logic
    car.getFuelEntries().add(fuelEntry);
    }

    public FuelStatsResponse getFuelStats(Long carId) {
    Car car = getCarById(carId);

    var entries = car.getFuelEntries();

    if (entries.size() < 2) {
        return new FuelStatsResponse(0, 0, 0);
    }

    double totalFuel = 0;
    double totalCost = 0;

    int minOdometer = Integer.MAX_VALUE;
    int maxOdometer = Integer.MIN_VALUE;

    for (FuelEntry entry : entries) {
        totalFuel += entry.getLiters();
        totalCost += entry.getPrice();

        minOdometer = Math.min(minOdometer, entry.getOdometer());
        maxOdometer = Math.max(maxOdometer, entry.getOdometer());
    }

    int distance = maxOdometer - minOdometer;

    double averageConsumption = (distance > 0)
            ? (totalFuel / distance) * 100
            : 0;

    return new FuelStatsResponse(totalFuel, totalCost, averageConsumption);
}
}