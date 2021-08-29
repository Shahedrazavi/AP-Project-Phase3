package ui.profile;

import controller.profile.ProfileLogic;
import model.User;
import response.Response;
import ui.Component;
import ui.component.profileHeader.ProfileHeader;
import ui.component.tweetViewer.TVContainerComponent;
import ui.component.tweetViewer.TweetViewer;
import ui.mainView.MainPage;

public class Profile extends TVContainerComponent {

    private User targetUser;
    private Component profileHeader;
    private Component tweetSection;
    private boolean isSelfProfile;

//    private ProfileLogic logic;

    public Profile(String fxmlName, MainPage parent , User loggedInUser , User targetUser) {
        super(fxmlName);
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
        fillTweetSection(controller);
    }

    public void fillTweetSection(ProfileFXMLController controller){
        //send request
        tweetSection = new TweetViewer("tweetViewer",graphicalAgent,this, loggedInUser,(MainPage) parent);
        controller.hidePrivateLabel();
        controller.setTweetSection();
    }

    public void updateTweets(Response response){

    }

    public Component getProfileHeader() {
        return profileHeader;
    }

    public Component getTweetSection() {
        return tweetSection;
    }

}
