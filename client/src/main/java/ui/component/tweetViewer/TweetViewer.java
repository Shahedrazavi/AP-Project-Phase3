package ui.component.tweetViewer;

import model.Tweet;
import model.User;
import ui.Component;
import ui.GraphicalAgent;
import ui.component.tweetComponent.TweetComponent;
import ui.mainView.MainPage;

import java.util.LinkedList;

public class TweetViewer extends Component {
    private LinkedList<Tweet> tweets;
    private int index;
    private User loggedInUser;

    private MainPage mainPage;

    public TweetViewer(String fxmlName, GraphicalAgent graphicalAgent, TVContainerComponent parent, User loggedInUser , MainPage mainPage) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        setLoggedInUser(loggedInUser);
        this.index = 0;
        this.loggedInUser = loggedInUser;
        this.mainPage = mainPage;
        initialize();
    }

    @Override
    public void initialize() {
        TweetViewerFXMLController controller = (TweetViewerFXMLController) fxmlController;
        controller.setComponent(this);
        controller.initializeListener();
        fillComponent(controller);
    }

    public void fillComponent(TweetViewerFXMLController controller){
        if (tweets.isEmpty()){
            controller.disableButtons();
            controller.showEmptyLabel();
        }
        else {
            index = tweets.size()-1;
            showTweetComponent(controller);
        }
    }

    public void showTweetComponent(TweetViewerFXMLController controller){
        if (index==0){
            controller.disableNext();
        }
        else{
            controller.enableNext();
        }
        if (index==tweets.size()-1){
            controller.disablePrevious();
        }
        else {
            controller.enablePrevious();
        }
        Tweet showingTweet = tweets.get(index);
        TweetComponent tweetComponent = new TweetComponent("tweetComponent",graphicalAgent,this,showingTweet,loggedInUser);
        controller.setComponentPane(tweetComponent);
    }

    public void goToNext(){
        index--;
        showTweetComponent((TweetViewerFXMLController)fxmlController);
    }

    public void goToPrevious(){
        index++;
        showTweetComponent((TweetViewerFXMLController)fxmlController);

    }

    public void goToProfile(User user){
        mainPage.goToProfile(user);
    }

    public LinkedList<Tweet> getTweets() {
        return tweets;
    }
}
