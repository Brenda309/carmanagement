package com.brenda.carmanagement.dto;

public class FuelStatsResponse {
  private double totalFuel;
    private double totalCost;
    private double averageConsumption;

    public FuelStatsResponse(double totalFuel, double totalCost, double averageConsumption) {
        this.totalFuel = totalFuel;
        this.totalCost = totalCost;
        this.averageConsumption = averageConsumption;
    }

    public double getTotalFuel() {
        return totalFuel;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getAverageConsumption() {
        return averageConsumption;
    }
}
