package controller;

//import ap.mini_project.server.controller.network.SocketResponseSender;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager extends Thread{

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            while (true) {
                Socket socket = serverSocket.accept();
//                ClientHandler clientHandler = new ClientHandler(new SocketResponseSender(socket),gameLobby);
//                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
