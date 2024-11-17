package org.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public interface ISocketServer {
     void start(int port) throws Exception;
     void close( BufferedReader in, PrintWriter out, Socket socket ) throws IOException;
}
