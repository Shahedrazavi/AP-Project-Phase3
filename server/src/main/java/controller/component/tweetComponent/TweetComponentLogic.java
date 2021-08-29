package controller.component.tweetComponent;

import model.ID;
import model.Tweet;
import model.User;
import response.Response;

public class TweetComponentLogic {
    private Tweet tweet;
    private User loggedInUser;

    private TweetController tweetController;
    private UserController userController;

    public TweetComponentLogic(Tweet tweet, User loggedInUser) {
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

    public void checkReport(){
        if (!isReported()){
            report();
        }
    }

    public boolean isReported(){
        return tweet.getReports().contains(loggedInUser.getId());
    }

    public void report(){
        tweetController.report();
    }

    public void checkRetweet(){
        if (!isRetweeted()){
            retweet();
        }
    }

    public boolean isRetweeted(){
        return tweetController.isRetweetedByLoggedUser();
    }

    public void retweet(){
        tweetController.retweet();
    }

    public void save(){
        // coming soon //
    }

    public Response viewComments(){
        return null;
    }


    public String getUsername(ID id){
        return userController.getUsername(id);
    }
}
