package com.brenda.carmanagement.model;
import java.util.ArrayList;
import java.util.List;



public class Car {

    private Long id;
    private String brand;
    private String model;
    private int year;
    private List<FuelEntry> fuelEntries = new ArrayList<>();
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public List<FuelEntry> getFuelEntries() {
        return fuelEntries;
    }
    public void setFuelEntries(List<FuelEntry> fuelEntries) {
        this.fuelEntries = fuelEntries;
    }

    // getters & setters
}

