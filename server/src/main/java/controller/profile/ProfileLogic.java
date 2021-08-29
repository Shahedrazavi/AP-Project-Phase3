package controller.profile;

import model.Tweet;
import model.User;

import java.util.LinkedList;

public class ProfileLogic{
    private User loggedInUser;

    private ProfileController controller;


    public ProfileLogic(User loggedInUser) {
        controller = new ProfileController();
        this.loggedInUser = loggedInUser;
    }

    public LinkedList<Tweet> getUserTweets(){
        return controller.getUserTweets(loggedInUser);
    }
}
