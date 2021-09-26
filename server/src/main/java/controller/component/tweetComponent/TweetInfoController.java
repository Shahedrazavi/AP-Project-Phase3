package controller.component.tweetComponent;

import controller.Controller;
import model.Tweet;

public class TweetInfoController extends Controller {
    private Tweet tweet;

    public TweetInfoController(Tweet tweet) {
        this.tweet = tweet;
    }

    public String getRetweeter(){
        if (tweet.getRetweeterID()==null){
            return "";
        }
        return context.users.get(tweet.getRetweeterID()).getUsername();
    }

    public String getProfileName(){
        return context.users.get(tweet.getWriterID()).getProfileName();
    }

    public String getUsername(){
        return context.users.get(tweet.getWriterID()).getUsername();
    }

    public String getReplyingTo(){
        if (tweet.getUpperTweetID()==null){
            return "";
        }
        return context.users.get(context.tweets.get(tweet.getUpperTweetID()).getWriterID()).getUsername();
    }
}
