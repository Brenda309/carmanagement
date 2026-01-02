package com.brenda.carmanagement.servlet;

import java.io.IOException;

import org.springframework.web.server.ResponseStatusException;

import com.brenda.carmanagement.dto.FuelStatsResponse;
import com.brenda.carmanagement.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FuelStatsServlet extends HttpServlet {

    private final CarService carService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public FuelStatsServlet(CarService carService) {
        this.carService = carService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String carIdParam = req.getParameter("carId");

        if (carIdParam == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Missing carId parameter");
            return;
        }

        try {
            Long carId = Long.parseLong(carIdParam);

            FuelStatsResponse stats = carService.getFuelStats(carId);

            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_OK);

            objectMapper.writeValue(resp.getWriter(), stats);

        } catch (ResponseStatusException e) {
    resp.setStatus(e.getStatusCode().value());
    resp.getWriter().write(e.getReason());

        }
    }
}
