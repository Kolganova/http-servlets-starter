package com.kolganova.http.service;

import com.kolganova.http.dao.FlightDao;
import com.kolganova.http.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FlightService {

    public static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight ->
                        new FlightDto(
                                flight.getId(),
                                """
                                       %s - %s - %s
                                """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus())
                        )).collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
