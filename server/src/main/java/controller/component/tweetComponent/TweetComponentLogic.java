package controller.component.tweetComponent;

import model.ID;
import model.Tweet;
import model.User;
import ui.component.tweetComponent.TweetComponent;

public class TweetComponentLogic {
    private Tweet tweet;
    private User loggedInUser;

    private TweetController tweetController;
    private UserController userController;

    private TweetComponent tweetComponent;

    public TweetComponentLogic(TweetComponent tweetComponent,Tweet tweet) {
        this.tweetComponent = tweetComponent;
        this.tweet = tweet;
        this.loggedInUser = loggedInUser;

        tweetController = new TweetController(tweet, loggedInUser);
        userController = new UserController();
    }

    public void checkLike(){
        if (isLiked()){
            like();
        }
        if (!isLiked()){
            unlike();
        }
    }

    public boolean isLiked(){
        return tweet.getLikes().contains(loggedInUser.getId());
    }

    public void like(){
        tweetController.like();
    }

    public void unlike(){
        tweetController.unlike();
    }

    public boolean isReported(){
        return tweet.getReports().contains(loggedInUser.getId());
    }

    public void report(){
        tweetController.report();
    }

    public boolean isRetweeted(){
        return tweetController.isRetweetedByLoggedUser();
    }

    public void retweet(){
        tweetController.retweet();
    }

    public boolean isMuted(){
        return tweetController.isMuted();
    }

    public void mute(){
        tweetController.mute();
    }

    public boolean isBlocked(){
        return tweetController.isBlocked();
    }

    public void block() {
        tweetController.block();
    }

    public void save(){
        // coming soon //
    }

    public void comment(){
    }

    public void viewComments(){

    }

    public void forwardTo(){

    }

    public void viewProfile(){
        tweetComponent.goToProfile(tweetController.getTweetUser());
    }

    public void viewTweetPhoto(){

    }

    public String getUsername(ID id){
        return userController.getUsername(id);
    }
}
