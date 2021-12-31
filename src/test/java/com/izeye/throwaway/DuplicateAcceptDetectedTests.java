package com.izeye.throwaway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Tests for reproducing "Duplicate accept detected. This is a known OS bug. Please consider reporting that you are affected: https://bugs.launchpad.net/ubuntu/+source/linux/+bug/1924298" from Apache Tomcat.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DuplicateAcceptDetectedTests {

    // From "sysctl net.inet.tcp.msl" on macOS.
    private static final Duration MSL = Duration.ofMillis(15_000);
    private static final Duration TIME_WAIT = MSL.multipliedBy(2);

    @LocalServerPort
    private int port;

    @Test
    void test() throws IOException, InterruptedException {
        InetAddress remoteAddress = InetAddress.getByName("localhost");
        int remotePort = this.port;

        Socket socket = new Socket(remoteAddress, remotePort, null, 0);

        int localPort = socket.getLocalPort();
        System.out.println("Local port: " + localPort);

        socket.close();

        System.out.println(String.format("Sleep for 2 * MSL (%d ms)...", TIME_WAIT.toMillis()));
        TimeUnit.MILLISECONDS.sleep(TIME_WAIT.toMillis());

        boolean succeeded = false;
        while (!succeeded) {
            try {
                connect(remoteAddress, remotePort, localPort);
                succeeded = true;
            }
            catch (Exception ex) {
                System.out.println("Sleep for a second...");
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    private static void connect(InetAddress remoteAddress, int remotePort, int localPort) throws IOException {
        new Socket(remoteAddress, remotePort, null, localPort);
    }

}
