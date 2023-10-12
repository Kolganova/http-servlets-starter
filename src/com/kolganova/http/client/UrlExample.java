package com.kolganova.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("file:/Users/kiskadi/IdeaProjects/http-servlets-starter/src/com/kolganova/http/socket/DatagramRunner.java");
        URLConnection connection = url.openConnection();
        String string = new String(connection.getInputStream().readAllBytes());
        System.out.println(string);
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://www.google.com");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        try (OutputStream outputStream = urlConnection.getOutputStream()) {
        }
        System.out.println();
    }
}
