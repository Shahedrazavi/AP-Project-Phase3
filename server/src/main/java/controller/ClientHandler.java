package controller;

import event.EventVisitor;

public class ClientHandler implements EventVisitor {
    private volatile boolean running;


    public void start(){
        running = true;

    }
}
