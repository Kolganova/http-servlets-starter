package com.kolganova.http.service;

import com.kolganova.http.dao.FlightDao;
import com.kolganova.http.dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.*;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();
    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> FlightDto.builder().id(flight.getId()).description(
                                """
                                               %s - %s - %s
                                        """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus()))
                                        .build()
                        ).collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
