package ui.profile;

import controller.profile.ProfileLogic;
import model.User;
import ui.Component;
import ui.component.profileHeader.ProfileHeader;
import ui.component.tweetViewer.TVContainerComponent;
import ui.component.tweetViewer.TweetViewer;
import ui.mainView.MainPage;

public class Profile extends TVContainerComponent {

    private Component profileHeader;
    private Component tweetSection;

    private ProfileLogic logic;

    public Profile(String fxmlName, MainPage parent , User loggedInUser) {
        super(fxmlName);
        setParent(parent);
        setLoggedInUser(loggedInUser);
        logic = new ProfileLogic(loggedInUser);
        initialize();
    }

    @Override
    public void initialize() {
        ProfileFXMLController controller = (ProfileFXMLController) fxmlController;
        controller.setComponent(this);
        profileHeader = new ProfileHeader("profileHeader",this,loggedInUser);
        controller.setProfileSection();
        fillTweetSection(controller);
    }

    public void fillTweetSection(ProfileFXMLController controller){
        tweetSection = new TweetViewer("tweetViewer",this, logic.getUserTweets(), loggedInUser,(MainPage) parent);
        controller.hidePrivateLabel();
        controller.setTweetSection();
    }

    public Component getProfileHeader() {
        return profileHeader;
    }

    public Component getTweetSection() {
        return tweetSection;
    }

    public ProfileLogic getLogic() {
        return logic;
    }
}
