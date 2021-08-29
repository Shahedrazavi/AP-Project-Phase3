package controller.component.tweetComponent;

import controller.Controller;
import model.ID;
import model.Tweet;
import model.User;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class TweetController extends Controller {
    private Tweet tweet;
    private User loggedInUser;

    public TweetController(Tweet tweet, User loggedInUser) {
        super();
        this.tweet = tweet;
        this.loggedInUser = loggedInUser;
    }

    public void like(){
        tweet.addLike(loggedInUser.getId());
        for (Tweet tweet : context.tweets.getAll()){
            if (isTweetARetweet(tweet))
                if (tweet.getParentTweetID().equals(tweet.getId()))
                    tweet.addLike(loggedInUser.getId());
        }

        context.tweets.update(tweet);
    }

    public void unlike(){
        tweet.removeLike(loggedInUser.getId());
        for (Tweet tweet : context.tweets.getAll()){
            if (isTweetARetweet(tweet))
                if (tweet.getParentTweetID().equals(tweet.getId()))
                    tweet.removeLike(loggedInUser.getId());
        }
        context.tweets.update(tweet);
    }

    public void report(){
        tweet.addReport(loggedInUser.getId());
        for (Tweet tweet : context.tweets.getAll()){
            if (isTweetARetweet(tweet))
                if (tweet.getParentTweetID().equals(tweet.getId()))
                    tweet.addReport(loggedInUser.getId());
        }
        context.tweets.update(tweet);
    }

    public void retweet(){
        context.tweets.increaseLastID();
        ID parentTweetID = tweet.getId();
        if(isTweetARetweet(tweet)){
            parentTweetID = tweet.getParentTweetID();
        }

        Tweet newRetweet = new Tweet(context.tweets.getLastID(),tweet.getText(),tweet.getImageID(),
                tweet.getCreateTime(), LocalDateTime.now(),tweet.getWriterID(),loggedInUser.getId(),
                new LinkedList<>(tweet.getLikes()),new LinkedList<>(tweet.getComments()),new LinkedList<>(tweet.getReports()),
                tweet.getUpperTweetID(),parentTweetID);
        context.tweets.add(newRetweet);
    }



    public Tweet getTweetByID(ID id){
        return context.tweets.get(id);
    }

    public boolean isRetweetedByLoggedUser(){
        return loggedInUser.getTweets().stream().anyMatch(id -> getTweetByID(id).getParentTweetID().equals(tweet.getId()));
    }

    private boolean isTweetARetweet(Tweet tweet){
        return tweet.getParentTweetID()!=null;
    }
}
