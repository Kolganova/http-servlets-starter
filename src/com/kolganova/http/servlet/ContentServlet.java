package com.kolganova.http.servlet;

import com.kolganova.http.dto.FlightDto;
import com.kolganova.http.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.kolganova.http.service.FlightService.*;
import static com.kolganova.http.util.JspHelper.*;
import static java.util.stream.Collectors.*;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDto> flightDtos = flightService.findAll();
        req.setAttribute("flights", flightDtos);
        req.getSession().setAttribute("flightsMap", flightDtos
                .stream()
                .collect(toMap(FlightDto::getId, FlightDto::getDescription)));
        req.getRequestDispatcher(getPath("content"))
                .forward(req, resp);
    }
}
