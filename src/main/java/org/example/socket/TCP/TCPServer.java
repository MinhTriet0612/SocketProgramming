package org.example.socket.TCP;

import org.example.socket.ISocketServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer implements ISocketServer {
    private ServerSocket socket;

    public TCPServer() {
        try {
            socket = new ServerSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(int port) throws Exception {
        try {
            socket.bind(new InetSocketAddress(port));

            while(true) {
                Socket client = socket.accept();
                System.out.println("Client has connected");
                new Thread(new TCPClientHandler(client)).start();
            }

        } catch (SocketException e) {
            System.out.println("Socket closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close(BufferedReader in, PrintWriter out, Socket socket) throws IOException {
        in.close();
        out.close();
        socket.close();
    }


}
