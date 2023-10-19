package com.kolganova.http.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/flights");

//        req.getRequestDispatcher("/flights").include(req, resp);
//        PrintWriter writer = resp.getWriter();
//        writer.write("Hi from dispatcher");
//
//        System.out.println();
//        req.setAttribute("1", "234");
    }
}
