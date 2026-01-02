package com.brenda.carmanagement.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brenda.carmanagement.service.CarService;
import com.brenda.carmanagement.servlet.FuelStatsServlet;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<FuelStatsServlet> fuelStatsServlet(
            CarService carService
    ) {
        return new ServletRegistrationBean<>(
                new FuelStatsServlet(carService),
                "/servlet/fuel-stats"
        );
    }
}
