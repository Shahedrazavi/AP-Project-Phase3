package controller;

import config.Config;
import controller.auth.registration.RegistrationPage1Logic;
import controller.auth.registration.RegistrationPage2Logic;
import controller.auth.signIn.SignInPageLogic;
import controller.newTweet.NewTweetLogic;
import controller.settings.SettingsLogic;
import event.Event;
import event.EventVisitor;
import event.auth.registration.RegistrationFormEvent;
import event.auth.signIn.SignInFormEvent;
import event.newTweet.NewTweetEvent;
import event.opening.OpeningEvent;
import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import event.settings.SettingsStringEvent;
import model.User;
import response.EmptyResponse;
import response.Response;
import response.auth.sidebar.LogOutResponse;
import util.Logger;
import util.TimeTask;

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
        return new EmptyResponse();
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

    @Override
    public Response logOut(User user) {
        new TimeTask(Config.getConfig("time").getProperty(Integer.class,"exitWait"),
                ()-> this.running = false).start();
        Logger.getLogger().logOut(user.getUsername(),user.getId().toString());
        return new LogOutResponse();
    }

    @Override
    public Response newTweet(NewTweetEvent newTweetEvent) {
        return new NewTweetLogic().checkForTweet(newTweetEvent);
    }

    @Override
    public Response changePass(ChangePassEvent changePassEvent) {
        return new SettingsLogic().checkForChangingPass(changePassEvent);
    }

    @Override
    public Response deleteAcc(SettingsStringEvent settingsStringEvent) {
        return new SettingsLogic().deleteAcc(settingsStringEvent);
    }

    @Override
    public Response deactivateAcc(SettingsStringEvent settingsStringEvent) {
        return new SettingsLogic().changeActivate(settingsStringEvent);
    }

    @Override
    public Response changeAccType(ComboBoxEvent comboBoxEvent) {
        return new SettingsLogic().changeAccType(comboBoxEvent);
    }

    @Override
    public Response changeLastSeen(ComboBoxEvent comboBoxEvent) {
        return new SettingsLogic().changeLastSeenType(comboBoxEvent);
    }
}
