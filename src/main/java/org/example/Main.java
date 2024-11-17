package org.example;

import org.example.socket.ISocketServer;
import org.example.socket.SocketFactory;
import org.example.type.SocketConnectionType;

public class Main {
    public static void main(String[] args) throws Exception {
        ISocketServer socketServer = SocketFactory.createSocket(SocketConnectionType.TCP);
        socketServer.start(1234);
    }
}