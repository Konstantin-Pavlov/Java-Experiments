package org.example.socketExample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static EchoServer bindToPort(int port) {
        return new EchoServer(port);

    }

    public void run() throws IOException {
        try (var server = new ServerSocket(port)) {
            System.out.println("Сервер работает...");
            while (true) {
                try (var clientSocket = server.accept()) {
                    handle(clientSocket);
                } catch (IOException e) {
                    System.out.println("не удалось подключиться");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.printf("вероятнее всего порт  %s занят. %n", port);
            e.printStackTrace();
        }
    }
    private void handle (Socket socket) throws IOException {
        var input = socket.getInputStream();
        var output = socket.getOutputStream();
        var isr = new InputStreamReader(input, "UTF-8");
        var out = new OutputStreamWriter(output, "UTF-8");
        try (var scanner = new Scanner(isr); var writer = new PrintWriter(out, true)) {
            while (true) {
                var message = scanner.nextLine().strip();
                var reversMessege = new StringBuilder(message).reverse().toString();
                System.out.printf("Got: %s %n", reversMessege);
                if (message.equalsIgnoreCase("bye")) {
                    writer.println("Bye bye");
                    System.out.println("bye bye");
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Client dropped connection.");
        }


    }

}
