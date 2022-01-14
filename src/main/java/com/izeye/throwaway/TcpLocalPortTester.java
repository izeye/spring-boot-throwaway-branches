package com.izeye.throwaway;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Tester for TCP local port.
 *
 * @author Johnny Lim
 */
public class TcpLocalPortTester {

    public static void main(String[] args) throws IOException {
        InetSocketAddress socketAddress = new InetSocketAddress("www.google.com", 80);
        Socket socket = new Socket();
        socket.connect(socketAddress);
        System.out.println("Local port: " + socket.getLocalPort());
        socket.close();
    }

}
