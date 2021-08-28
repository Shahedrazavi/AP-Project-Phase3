import event.Event;
import javafx.application.Platform;
import javafx.stage.Stage;
import listener.EventSender;
import listener.network.SocketEventSender;
import response.Response;
import response.ResponseVisitor;
import response.auth.registration.RegPage1Response;
import response.auth.registration.RegPage2Response;
import response.auth.signIn.SignInResponse;
import response.newTweet.NewTweetResponse;
import ui.GraphicalAgent;
import ui.auth.SignInPage;
import ui.auth.SignUpPage;
import ui.auth.registration.RegistrationPage1FXMLController;
import ui.auth.registration.RegistrationPage2FXMLController;
import ui.auth.signIn.SignInCenterFXMLController;
import ui.newTweet.NewTweet;
import ui.newTweet.NewTweetFXMLController;
import util.Logger;
import util.Loop;

import java.util.LinkedList;

public class LogicalAgent implements ResponseVisitor {
    private final EventSender eventSender;
    private LinkedList<Event> events;
//    private Loop sendEventLoop;
    private Object lock;
    private GraphicalAgent graphicalAgent;


    public LogicalAgent(SocketEventSender socketEventSender , Stage stage) {
        this.eventSender = socketEventSender;
        this.events = new LinkedList<>();
        graphicalAgent = new GraphicalAgent(this::addEvent , stage);
        lock = new Object();
//        sendEventLoop = new Loop(15,this::sendEvents);
    }

    private void addEvent(Event event){
        synchronized (lock){
            Response serverResponse = eventSender.send(event);
            if (serverResponse != null) serverResponse.visit(this);
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
    public void finalizeRegPage1(RegPage1Response regPage1Response) {
        ((RegistrationPage1FXMLController)((SignUpPage)graphicalAgent.getPage()).getPage1().getFxmlController()).finalizePage(regPage1Response);
    }

    @Override
    public void finalizeRegPage2(RegPage2Response regPage2Response) {
        ((RegistrationPage2FXMLController)((SignUpPage)graphicalAgent.getPage()).getPage2().getFxmlController()).finalizePage(regPage2Response);
    }

    @Override
    public void finalizeSignIn(SignInResponse signInResponse) {
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
}
