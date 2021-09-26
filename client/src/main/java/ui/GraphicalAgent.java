package ui;

import event.Event;
import javafx.stage.Stage;
import listener.EventListener;
import logicalAgent.LogicalAgent;
import model.User;
import ui.auth.SignInPage;
import ui.auth.SignUpPage;
import ui.mainView.MainPage;
import ui.opening.OpeningPage;

import java.util.Stack;

public class GraphicalAgent {
    private final EventListener listener;
    private LogicalAgent logicalAgent;

    private Stack<Page> pageStack;

    private Stage stage;
    private Page page;
    private MainPage mainPage;


    public GraphicalAgent(EventListener listener , LogicalAgent logicalAgent) {
        this.listener = listener;
        this.pageStack = new Stack<>();
        this.logicalAgent = logicalAgent;
    }

    public EventListener getListener() {
        return listener;
    }

    public LogicalAgent getLogicalAgent() {
        return logicalAgent;
    }

    public void initialize(){
        page = new OpeningPage("opening" ,this);
        stage = new MainStage();
        pageStack.add(page);
        stage.setScene(page.getScene());
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void goToSignIn(Event event){
        page = new SignInPage("signIn", this);
        pageStack.add(page);
        stage.setScene(page.getScene());
    }

    public void goToSignUp(Event event){
        page = new SignUpPage("signUp" , this);
        pageStack.add(page);
        stage.setScene(page.getScene());
    }

    public void startMainApp(User user){
        MainPage mainPage = new MainPage(user,this,"main" );
        page = mainPage;
        this.mainPage = mainPage;
        pageStack.pop();
        pageStack.add(page);
        stage.setScene(page.getScene());
    }

    public void goToOpeningPage(){
        pageStack.pop();
        stage.setScene(pageStack.peek().getScene());
    }

    public void removeLastScene(){
        pageStack.pop();
    }

    public Page getPage() {
        return page;
    }

    public Stage getStage() {
        return stage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

}
