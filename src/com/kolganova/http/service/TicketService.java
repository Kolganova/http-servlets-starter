package com.kolganova.http.service;

import com.kolganova.http.dao.TicketDao;
import com.kolganova.http.dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.*;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();
    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> TicketDto.builder().id(ticket.getId()).flightId(ticket.getFlightId()).seatNo(ticket.getSeatNo()).build()
                ).collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
