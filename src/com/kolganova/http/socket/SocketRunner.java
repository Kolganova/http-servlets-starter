package com.kolganova.http.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {

    public static void main(String[] args) throws IOException {
        var inetAddress = Inet4Address.getByName("localhost");
        try (Socket socket = new Socket(inetAddress, 7777);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                var request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println("Response from server: " + inputStream.readUTF());

            }
        }
    }
}
