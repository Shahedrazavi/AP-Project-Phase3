package logicalAgent;

import event.Event;
import javafx.application.Platform;
import javafx.stage.Stage;
import listener.EventSender;
import listener.network.SocketEventSender;
import response.Response;
import response.ResponseVisitor;
import response.TweetInfoResponse;
import response.TweetsListResponse;
import response.auth.registration.RegPage1Response;
import response.auth.registration.RegPage2Response;
import response.auth.signIn.SignInResponse;
import response.newTweet.NewTweetResponse;
import response.settings.ChangePassResponse;
import ui.GraphicalAgent;
import ui.auth.SignInPage;
import ui.auth.SignUpPage;
import ui.auth.registration.RegistrationPage1FXMLController;
import ui.auth.registration.RegistrationPage2FXMLController;
import ui.auth.signIn.SignInCenterFXMLController;
import ui.component.tweetComponent.TweetComponent;
import ui.component.tweetViewer.TweetViewer;
import ui.newTweet.NewTweet;
import ui.newTweet.NewTweetFXMLController;
import ui.profile.Profile;
import ui.settings.SettingsFXMLController;
import ui.tweetsPage.TweetsPage;
import util.Logger;
import util.Loop;

import java.util.LinkedList;
import java.util.Set;

public class LogicalAgent implements ResponseVisitor {
    private int token;
    private final EventSender eventSender;
    private LinkedList<Event> events;
//    private Loop sendEventLoop;
    private Object lock;
    private GraphicalAgent graphicalAgent;


    public LogicalAgent(SocketEventSender socketEventSender , Stage stage) {
        this.eventSender = socketEventSender;
        this.events = new LinkedList<>();
        graphicalAgent = new GraphicalAgent(this::addEvent , this);
        lock = new Object();
        token = 0;
//        sendEventLoop = new Loop(15,this::sendEvents);
    }

    private void addEvent(Event event){
        synchronized (lock){
            event.setToken(token);
            try {
                Response serverResponse = eventSender.send(event);
                if (serverResponse != null) serverResponse.visit(this);
            }catch (Throwable t){
                Response offlineResponse = eventSender.send(event);
                offlineResponse.visit(this);
            }

//            events.add(event);
//            System.out.println("event added");
        }
    }

//    private void sendEvents(){
//        LinkedList<Event> doneRequests;
//        synchronized (events) {
//            doneRequests = new LinkedList<>(events);
//            events.clear();
//        }
//        for (Event event :
//                doneRequests) {
//            try {
//                System.out.println("trying to send response");
//                Response serverResponse = eventSender.send(event);
//                System.out.println("got response");
//                if (serverResponse != null) serverResponse.visit(this);
//            } catch (Throwable throwable) {
////                logger.info("User Did Action In Offline");
////                Response offlineResponse = event.visit(offlineHandler);
////                offlineResponse.visit(this);
//            }
//        }
//    }

    public void start() {
//        sendEventLoop.start();
        graphicalAgent.initialize();
    }

    @Override
    public void getEmptyResponse() {

    }

    @Override
    public void finalizeRegPage1(RegPage1Response regPage1Response) {
        ((RegistrationPage1FXMLController)((SignUpPage)graphicalAgent.getPage()).getPage1().getFxmlController()).finalizePage(regPage1Response);
    }

    @Override
    public void finalizeRegPage2(RegPage2Response regPage2Response) {
        ((RegistrationPage2FXMLController)((SignUpPage)graphicalAgent.getPage()).getPage2().getFxmlController()).finalizePage(regPage2Response);
    }

    @Override
    public void finalizeSignIn(SignInResponse signInResponse) {
        token = signInResponse.getToken();
        ((SignInCenterFXMLController)((SignInPage)graphicalAgent.getPage()).getSignInCenter().getFxmlController()).finalizeComp(signInResponse);
    }

    @Override
    public void logOut() {
        Platform.exit();
        Logger.getLogger().exit();
        System.exit(0);
    }

    @Override
    public void goBackFromNewTweet(NewTweetResponse newTweetResponse) {
        ((NewTweetFXMLController)graphicalAgent.getMainPage().getCenterComp().getFxmlController()).finalizeComp(newTweetResponse);
    }

    @Override
    public void changePass(ChangePassResponse changePassResponse) {
        ((SettingsFXMLController)graphicalAgent.getMainPage().getCenterComp().getFxmlController()).showLabel(changePassResponse);
    }

    @Override
    public void activation() {
        ((SettingsFXMLController)graphicalAgent.getMainPage().getCenterComp().getFxmlController()).exit();
    }

    @Override
    public void deleteAcc() {
        ((SettingsFXMLController)graphicalAgent.getMainPage().getCenterComp().getFxmlController()).exit();
    }

    @Override
    public void startClient() {

    }

    @Override
    public void exitClient() {
        eventSender.close();
        Logger.getLogger().exit();
        graphicalAgent.getStage().close();
        System.exit(0);
    }

    @Override
    public void receiveTweetList(TweetsListResponse response) {
        if (response.getCommand().equals("profile")){
            ((Profile)graphicalAgent.getMainPage().getCenterComp()).updateTweets(response);
        }
        else {
            ((TweetsPage)graphicalAgent.getMainPage().getCenterComp()).updateTweets(response);
        }
    }

    @Override
    public void receiveTweetInfo(TweetInfoResponse response) {
        System.out.println(response.getProfileName());
        if (graphicalAgent.getMainPage().getState()==0){
            ((TweetViewer)((Profile)graphicalAgent.getMainPage().getCenterComp()).getTweetSection()).
                    getTweetComponent().
                    setTweetInfo(response.getRetweeter(), response.getProfileName(), response.getUsername(), response.getReplyingTo());
        }
        if (graphicalAgent.getMainPage().getState()==1){
            ((TweetViewer)((TweetsPage)graphicalAgent.getMainPage().getCenterComp()).getTweetSection()).
                    getTweetComponent().
                    setTweetInfo(response.getRetweeter(), response.getProfileName(), response.getUsername(), response.getReplyingTo());
        }
    }
}
