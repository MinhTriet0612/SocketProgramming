package org.example.socket.TCP;

import java.io.*;
import java.net.Socket;

public class TCPClientHandler implements Runnable {
    private Socket client;

    TCPClientHandler(Socket client) throws IOException {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            String message;

            while((message = in.readLine()) != null) {
                System.out.println("Received request: " + message);
                String response = "Hello from server";
                out.println(response);
            }

            client.close();
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
