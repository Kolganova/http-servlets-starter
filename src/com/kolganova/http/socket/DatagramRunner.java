package com.kolganova.http.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            byte[] bytes = "Hello from UDP client!".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddress, 8081);
            datagramSocket.send(packet);
        }
    }
}
