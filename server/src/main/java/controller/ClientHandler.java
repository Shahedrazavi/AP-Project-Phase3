package controller;

import controller.auth.registration.RegistrationPage1Logic;
import controller.auth.registration.RegistrationPage2Logic;
import controller.auth.signIn.SignInPageLogic;
import event.Event;
import event.EventVisitor;
import event.auth.registration.RegistrationFormEvent;
import event.auth.signIn.SignInFormEvent;
import event.opening.OpeningEvent;
import response.Response;

public class ClientHandler extends Thread implements EventVisitor {
    private volatile boolean running;
    private final ResponseSender responseSender;


    public ClientHandler(ResponseSender responseSender) {
        this.responseSender = responseSender;
    }

    public synchronized void start(){
        running = true;
        super.start();
    }

    @Override
    public void run() {
        while (running){
            try {
                Event event = responseSender.getEvent();
                System.out.println("got event");
                responseSender.sendResponse(event.visit(this));
                System.out.println("sent response");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        responseSender.close();
    }

    @Override
    public Response open(OpeningEvent openingEvent) {
        return null;
    }

    @Override
    public Response signInCheck(SignInFormEvent signInFormEvent) {
        return new SignInPageLogic().check(signInFormEvent);
    }

    @Override
    public Response regInfoCheck1(RegistrationFormEvent registrationFormEvent) {
        return new RegistrationPage1Logic().check(registrationFormEvent);
    }

    @Override
    public Response regInfoCheck2(RegistrationFormEvent registrationFormEvent) {
        return new RegistrationPage2Logic().check(registrationFormEvent);
    }

}
