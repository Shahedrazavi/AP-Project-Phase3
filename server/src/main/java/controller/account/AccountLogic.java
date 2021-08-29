package controller.account;

import controller.component.tweetComponent.TweetController;
import model.Tweet;
import model.User;
import response.EmptyResponse;
import response.Response;

public class AccountLogic {
    private Tweet tweet;
    private User loggedInUser;

    private AccountController controller;

    public AccountLogic(Tweet tweet, User loggedInUser) {
        this.tweet = tweet;
        this.loggedInUser = loggedInUser;
        controller = new AccountController(tweet,loggedInUser);
    }

    public void checkMute(){
        if (!isMuted()){
            mute();
        }
    }

    public boolean isMuted(){
        return controller.isMuted();
    }

    public void mute(){
        controller.mute();
    }

    public void checkBlock(){
        if(!isBlocked()){
            block();
        }
    }

    public boolean isBlocked(){
        return controller.isBlocked();
    }

    public void block() {
        controller.block();
    }

    public Response goToProfile(){
        return new EmptyResponse();
    }
}
