package org.example.socket;

import org.example.socket.TCP.TCPServer;
import org.example.socket.UDP.UDPServer;
import org.example.type.SocketConnectionType;

public class SocketFactory {
    public static ISocketServer createSocket(SocketConnectionType type) throws Exception {
        return switch (type) {
            case TCP -> new TCPServer();
            case UDP -> new UDPServer();
        };
    }
}
