package com.kolganova.http.service;

import com.kolganova.http.dao.TicketDao;
import com.kolganova.http.dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.*;

public class TicketService {
    public static final TicketService INSTANCE = new TicketService();
    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo()
                )).collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
