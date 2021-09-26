package ui.tweetsPage;

import event.GetTweetsEvent;
import model.Tweet;
import model.User;
import response.TweetsListResponse;
import ui.Component;
import ui.GraphicalAgent;
import ui.TVContainerComponent;
import ui.component.tweetViewer.TweetViewer;
import ui.mainView.MainPage;
import ui.profile.ProfileFXMLController;

public class TweetsPage extends TVContainerComponent {
    private String command;
    private Component tweetSection;
    private Tweet targetTweet;

    public TweetsPage(String fxmlName, GraphicalAgent graphicalAgent , MainPage parent ,String command, User loggedInUser ) {
        super(fxmlName, graphicalAgent);
        this.command = command;
        this.targetTweet = null;
        setParent(parent);
        setLoggedInUser(loggedInUser);
        initialize();
    }

    public TweetsPage(String fxmlName, GraphicalAgent graphicalAgent, MainPage parent ,String command, User loggedInUser, Tweet targetTweet) {
        super(fxmlName, graphicalAgent);
        this.command = command;
        this.targetTweet = targetTweet;
        setParent(parent);
        setLoggedInUser(loggedInUser);
        initialize();
    }

    @Override
    public void initialize() {
        TweetsPageFXMLController controller = (TweetsPageFXMLController) fxmlController;
        controller.setComponent(this);
    }

    public void fillTweetSection(){
        TweetsPageFXMLController controller = (TweetsPageFXMLController) fxmlController;
        tweetSection = new TweetViewer("tweetViewer",graphicalAgent,this, loggedInUser,(MainPage) parent);
        if (command.equals("explore")){
            graphicalAgent.getListener().listen(new GetTweetsEvent(this,"explore"));
        }
        if (command.equals("timeline")){
            graphicalAgent.getListener().listen(new GetTweetsEvent(this,"timeline",loggedInUser));
        }
        if (command.equals("comments")){
            graphicalAgent.getListener().listen(new GetTweetsEvent(this,"comments",loggedInUser,targetTweet));
        }
        controller.setTweetSection();
        ((TweetViewer)tweetSection).fillComponent();
    }

    public void updateTweets(TweetsListResponse response){
        ((TweetViewer)tweetSection).setTweets(response.getTweets());
    }

    public Component getTweetSection() {
        return tweetSection;
    }
}
