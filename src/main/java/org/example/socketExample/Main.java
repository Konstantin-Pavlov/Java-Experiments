package org.example.socketExample;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EchoClient.connectTo(8089).run();
        EchoServer.bindToPort(8089).run();

    }
}
