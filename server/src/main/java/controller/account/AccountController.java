package controller.account;

import controller.Controller;
import model.ID;
import model.Tweet;
import model.User;

public class AccountController extends Controller {
    private Tweet tweet;
    private User loggedInUser;

    public AccountController(Tweet tweet, User loggedInUser) {
        super();
        this.tweet = tweet;
        this.loggedInUser = loggedInUser;
    }

    public boolean isMuted(){
        ID mutedID = tweet.getWriterID();
        if (isTweetARetweet(tweet)) {
            mutedID = tweet.getRetweeterID();
        }

        User mutedUser = context.users.get(mutedID);
        ID mutedUserID = mutedUser.getId();
        return loggedInUser.getMutedUsers().contains(mutedUserID);
    }

    public void mute(){
        ID mutedID = tweet.getWriterID();
        if (isTweetARetweet(tweet)) {
            mutedID = tweet.getRetweeterID();
        }

        User mutedUser = context.users.get(mutedID);
        ID mutedUserID = mutedUser.getId();
        loggedInUser.getMutedUsers().add(mutedUserID);
        context.users.update(loggedInUser);
    }

    public boolean isBlocked(){
        ID blockedID = tweet.getWriterID();
        if (isTweetARetweet(tweet)){
            blockedID = tweet.getRetweeterID();
        }

        User blockedUser = context.users.get(blockedID);
        ID blockedUserID = blockedUser.getId();
        return loggedInUser.getBlockedUsers().contains(blockedUserID);
    }

    public void block(){
        ID blockedID = tweet.getWriterID();
        if (isTweetARetweet(tweet)){
            blockedID = tweet.getRetweeterID();
        }

        User blockedUser = context.users.get(blockedID);
        ID blockedUserID = blockedUser.getId();
        loggedInUser.getBlockedUsers().add(blockedUserID);
        context.users.update(loggedInUser);
    }

    public User getTweetUser(){
        return context.users.get(tweet.getWriterID());
    }

    private boolean isTweetARetweet(Tweet tweet){
        return tweet.getParentTweetID()!=null;
    }
}
