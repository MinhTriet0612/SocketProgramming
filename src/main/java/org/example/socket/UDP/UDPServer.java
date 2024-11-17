package org.example.socket.UDP;

import org.example.socket.ISocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class UDPServer implements ISocketServer {

    DatagramSocket serverSocket;

    public UDPServer() throws SocketException {
        serverSocket = new DatagramSocket();
    }

    @Override
    public void start(int port) throws Exception {
        serverSocket.bind(new InetSocketAddress(port));

        byte[] receiveData = new byte[1024];
        byte[] sendData = null;

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String line = new String(receivePacket.getData());
            System.out.println("Received: " + line);

            System.out.println("Sent: " + line.toUpperCase());
            sendData = line.toUpperCase().getBytes();
            InetAddress host = receivePacket.getAddress();

            DatagramPacket sendPackage = new DatagramPacket(sendData, sendData.length, host, receivePacket.getPort());
            this.serverSocket.send(sendPackage);
        }
    }

    @Override
    public void close(BufferedReader in, PrintWriter out, Socket socket) throws IOException {
    }
}
