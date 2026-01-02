package com.brenda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command provided");
            return;
        }

        String command = args[0];

        if ("create-car".equals(command)) {
            handleCreateCar(args);
        } else {
            System.out.println("Unknown command: " + command);
        }
    }

    private static void handleCreateCar(String[] args) {
        String brand = null;
        String model = null;
        Integer year = null;

        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "--brand":
                    brand = args[++i];
                    break;
                case "--model":
                    model = args[++i];
                    break;
                case "--year":
                    year = Integer.parseInt(args[++i]);
                    break;
            }
        }

        if (brand == null || model == null || year == null) {
            System.out.println("Missing required arguments");
            return;
        }

        System.out.println("Creating car:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);

     try {
    String jsonBody = String.format(
            "{\"brand\":\"%s\",\"model\":\"%s\",\"year\":%d}",
            brand, model, year
    );

    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/api/cars"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

    HttpResponse<String> response =
            client.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println("Response status: " + response.statusCode());
    System.out.println("Response body:");
    System.out.println(response.body());

} catch (Exception e) {
    System.out.println("Failed to create car: " + e.getMessage());
}
    }
}