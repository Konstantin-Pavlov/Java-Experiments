package org.example.socketExample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EchoClient {
    private final String host;
    private final int port;

    private EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static EchoClient connectTo(int port) {
        var localhost = "127.0.0.1";
        return  new EchoClient(localhost, port);
    }
    public void run(){
        System.out.println("напиши 'bye' чтоб закрыть програму \n\n\n");
        try (var socket = new Socket(host,port)){
            var scanner = new Scanner(System.in, "UTF-8");
            var output =socket.getOutputStream();
            var writer = new PrintWriter(output);

            try (scanner; writer){
                while (true){
                    var messege = scanner.nextLine();
                    writer.write(messege);
                    writer.write(System.lineSeparator());
                    writer.flush();
                    if ("bye".equalsIgnoreCase(messege))
                        return;
                }


            }
//
//            throw new RuntimeException(e);
        }catch (NoSuchElementException e){
            System.out.println("Connection dropped!  ");
        }catch (IOException e) {
            System.out.printf("Can't connekt to   %s:%s !%n", host,port);

        }
    }
}
