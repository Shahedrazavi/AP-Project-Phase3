package ui.component.tweetViewer;

import model.Tweet;
import model.User;
import ui.Component;
import ui.GraphicalAgent;
import ui.TVContainerComponent;
import ui.component.tweetComponent.TweetComponent;
import ui.mainView.MainPage;

import java.util.LinkedList;

public class TweetViewer extends Component {
    private LinkedList<Tweet> tweets;
    private int index;
    private User loggedInUser;
    private TweetComponent tweetComponent;

    private MainPage mainPage;

    public TweetViewer(String fxmlName, GraphicalAgent graphicalAgent, TVContainerComponent parent, User loggedInUser , MainPage mainPage) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        setLoggedInUser(loggedInUser);
        this.index = 0;
        this.loggedInUser = loggedInUser;
        this.mainPage = mainPage;
        this.tweets = new LinkedList<>();
        initialize();
    }

    @Override
    public void initialize() {
        TweetViewerFXMLController controller = (TweetViewerFXMLController) fxmlController;
        controller.setComponent(this);
        controller.initializeListener();
        fillComponent();
    }

    public void fillComponent(){
        TweetViewerFXMLController controller = (TweetViewerFXMLController) fxmlController;
        if (tweets.isEmpty()){
            controller.disableButtons();
            controller.showEmptyLabel();
        }
        else {
            controller.hideEmptyLabel();
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
        tweetComponent = new TweetComponent("tweetComponent",graphicalAgent,this,showingTweet,loggedInUser);
        tweetComponent.initialize();
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

    public TweetComponent getTweetComponent() {
        return tweetComponent;
    }

    public void goToProfile(User user){
        mainPage.goToProfilePage(user);
    }

    public void setTweets(LinkedList<Tweet> tweets) {
        this.tweets = tweets;
    }
}
