package ui.mainView;

import event.sidebar.SidebarEvent;
import model.Tweet;
import model.User;
import ui.Component;
import ui.GraphicalAgent;
import ui.Page;
//import ui.profile.Profile;
import ui.newTweet.NewTweet;
import ui.profile.Profile;
import ui.settings.Settings;
import ui.sidebar.Sidebar;
import ui.tweetsPage.TweetsPage;
import util.Logger;
import util.Loop;

import java.util.Stack;

public class MainPage extends Page {
    protected Loop updateLoop;

    private int state;

    private Stack<Component> componentHistory;

    private Component sidebar;

    private Component centerComp;

    public MainPage(User loggedInUser, GraphicalAgent graphicalAgent, String fxmlName) {
        super(fxmlName, graphicalAgent);
        state = 0;
        setLoggedInUser(loggedInUser);
        componentHistory = new Stack<>();
        initialize();
    }


    public void initialize() {
        MainViewFXMLController controller= (MainViewFXMLController)fxmlController;
        controller.setPage(this);

        sidebar = new Sidebar("sidebar", graphicalAgent, this, loggedInUser);
        centerComp = new Settings("settings",graphicalAgent,this, loggedInUser);
        componentHistory.add(centerComp);
        controller.makeContents();
    }

    public int getState() {
        return state;
    }


    public Component getSidebar() {
        return sidebar;
    }

    public Component getCenterComp() {
        return centerComp;
    }

    public Stack<Component> getComponentHistory() {
        return componentHistory;
    }


    private void addNewCenterComp(){
        componentHistory.add(centerComp);
        ((MainViewFXMLController)fxmlController).setContentSection();
    }


    public void goToTimeline(){
        state = 1;
        centerComp = new TweetsPage("tweetsPage",graphicalAgent,this,"timeline",loggedInUser);
        ((TweetsPage)centerComp).fillTweetSection();
        addNewCenterComp();
    }

    public void goToExplore(){
        state = 1;
        centerComp = new TweetsPage("tweetsPage",graphicalAgent,this,"explore",loggedInUser);
        ((TweetsPage)centerComp).fillTweetSection();
        addNewCenterComp();
    }

    public void goToComments(Tweet targetTweet){
        state = 1;
        centerComp = new TweetsPage("tweetsPage",graphicalAgent,this,"comments",loggedInUser,targetTweet);
        ((TweetsPage)centerComp).fillTweetSection();
        addNewCenterComp();
    }

    public void goToSettingsPage() {
        centerComp = new Settings("settings",graphicalAgent,this,loggedInUser);
        addNewCenterComp();
    }

    public void goToProfilePage(User user) {
        state = 0;
        centerComp = new Profile("profile",graphicalAgent,this,loggedInUser, user);
        ((Profile)centerComp).fillTweetSection();
        addNewCenterComp();
    }

    public void goToNewTweetPage(){
        centerComp = new NewTweet("newTweet",graphicalAgent,this, loggedInUser);
        addNewCenterComp();
    }

    public void exit(){
        graphicalAgent.getListener().listen(new SidebarEvent(this,"logout",loggedInUser));
    }

    public void goBack(){
        if (componentHistory.size()>1){
            componentHistory.pop();
            centerComp = componentHistory.peek();
            centerComp.update();
            ((MainViewFXMLController)fxmlController).setContentSection();
        }
    }


    public void updateAll() {
        sidebar.update();
        for (Component component : componentHistory) {
            component.update();
        }
    }

    @Override
    public void updateApp() {
        sidebar.update();
        centerComp.update();
    }
}
