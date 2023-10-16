package com.kolganova.http.server;

public class HttpServerRunner {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(9090, 100);
        httpServer.run();
    }
}
