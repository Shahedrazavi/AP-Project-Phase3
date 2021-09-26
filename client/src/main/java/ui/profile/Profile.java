package ui.profile;

import event.GetTweetsEvent;
import model.User;
import response.Response;
import response.TweetsListResponse;
import ui.Component;
import ui.GraphicalAgent;
import ui.component.profileHeader.ProfileHeader;
import ui.TVContainerComponent;
import ui.component.tweetViewer.TweetViewer;
import ui.mainView.MainPage;

public class Profile extends TVContainerComponent {

    private User targetUser;
    private Component profileHeader;
    private Component tweetSection;
    private boolean isSelfProfile;

//    private ProfileLogic logic;

    public Profile(String fxmlName, GraphicalAgent graphicalAgent, MainPage parent , User loggedInUser , User targetUser) {
        super(fxmlName , graphicalAgent);
        setParent(parent);
        setLoggedInUser(loggedInUser);
        this.targetUser = targetUser;
        isSelfProfile = loggedInUser.equals(targetUser);
//        logic = new ProfileLogic(loggedInUser);
        initialize();
    }



    @Override
    public void initialize() {
        ProfileFXMLController controller = (ProfileFXMLController) fxmlController;
        controller.setComponent(this);
        profileHeader = new ProfileHeader("profileHeader",graphicalAgent,this,loggedInUser);
        controller.setProfileSection();
    }

    public void fillTweetSection(){
        ProfileFXMLController controller = (ProfileFXMLController) fxmlController;
        tweetSection = new TweetViewer("tweetViewer",graphicalAgent,this, loggedInUser,(MainPage) parent);
        graphicalAgent.getListener().listen(new GetTweetsEvent(this,"profile",loggedInUser,targetUser));
        controller.hidePrivateLabel();
        controller.setTweetSection();
        ((TweetViewer)tweetSection).fillComponent();
    }

    public void updateTweets(TweetsListResponse response){
        ((TweetViewer)tweetSection).setTweets(response.getTweets());
    }

    public Component getProfileHeader() {
        return profileHeader;
    }

    public Component getTweetSection() {
        return tweetSection;
    }

}
