package controller;

import config.Config;
import controller.account.AccountLogic;
import controller.auth.registration.RegistrationPage1Logic;
import controller.auth.registration.RegistrationPage2Logic;
import controller.auth.signIn.SignInPageLogic;
import controller.component.tweetComponent.TweetComponentLogic;
import controller.newTweet.NewTweetLogic;
import controller.settings.SettingsLogic;
import event.AccountEvent;
import event.Event;
import event.EventVisitor;
import event.auth.registration.RegistrationFormEvent;
import event.auth.signIn.SignInFormEvent;
import event.component.tweetComponent.TweetEvent;
import event.newTweet.NewTweetEvent;
import event.opening.OpeningEvent;
import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import event.settings.SettingsStringEvent;
import model.User;
import response.EmptyResponse;
import response.Response;
import response.auth.sidebar.LogOutResponse;
import response.auth.signIn.SignInResponse;
import util.Logger;
import util.TimeTask;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class ClientHandler extends Thread implements EventVisitor {
    private int token;
    private volatile boolean running;
    private final ResponseSender responseSender;
    private User user;


    public ClientHandler(ResponseSender responseSender) {
        this.responseSender = responseSender;
        token = 0;
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
                try {
                    if(event.getToken()==token) responseSender.sendResponse(event.visit(this));
                    else responseSender.sendResponse(new EmptyResponse());
                }catch (NullPointerException e){
                    shutdown();
                }
                System.out.println("sent response");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        responseSender.close();
    }

    private void shutdown(){
        new TimeTask(Config.getConfig("time").getProperty(Integer.class,"exitWait"),
                ()-> this.running = false).start();
        if(user!=null) Logger.getLogger().clientShutdown(user.getUsername(),user.getId().toString());
    }

    @Override
    public Response open(OpeningEvent openingEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response signInCheck(SignInFormEvent signInFormEvent) {
        SignInResponse signInResponse = new SignInPageLogic().check(signInFormEvent);
        if(signInResponse.isValid()){
            this.user = signInResponse.getSignedInUser();
            try {
                this.token = SecureRandom.getInstanceStrong().nextInt(Config.getConfig("random").getProperty(Integer.class,"upperbound"))+1;
                signInResponse.setToken(token);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return signInResponse;
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
        System.out.println("account type");
        return new SettingsLogic().changeAccType(comboBoxEvent);
    }

    @Override
    public Response changeLastSeen(ComboBoxEvent comboBoxEvent) {
        System.out.println("last seen");
        return new SettingsLogic().changeLastSeenType(comboBoxEvent);
    }

    @Override
    public Response likeTweet(TweetEvent tweetEvent) {
        new TweetComponentLogic(tweetEvent.getTweet(),tweetEvent.getLoggedInUser()).checkLike();
        return new EmptyResponse();
    }

    @Override
    public Response showComments(TweetEvent tweetEvent) {
        //Can be done
        return new EmptyResponse();
    }

    @Override
    public Response reportTweet(TweetEvent tweetEvent) {
        new TweetComponentLogic(tweetEvent.getTweet(),tweetEvent.getLoggedInUser()).checkReport();
        return new EmptyResponse();
    }

    @Override
    public Response retweetTweet(TweetEvent tweetEvent) {
        new TweetComponentLogic(tweetEvent.getTweet(),tweetEvent.getLoggedInUser()).checkRetweet();
        return new EmptyResponse();
    }

    @Override
    public Response savePressed(TweetEvent tweetEvent) {
        new TweetComponentLogic(tweetEvent.getTweet(),tweetEvent.getLoggedInUser());
        return new EmptyResponse();
    }

    @Override
    public Response blockAcc(AccountEvent accountEvent) {
        new AccountLogic(accountEvent.getTargetTweet(), accountEvent.getLoggedInUser()).checkBlock();
        return new EmptyResponse();
    }

    @Override
    public Response muteAcc(AccountEvent accountEvent) {
        new AccountLogic(accountEvent.getTargetTweet(), accountEvent.getLoggedInUser()).checkMute();
        return new EmptyResponse();
    }

    @Override
    public Response viewProfile(AccountEvent accountEvent) {
        return new AccountLogic(accountEvent.getTargetTweet(), accountEvent.getLoggedInUser()).goToProfile();
    }
}
