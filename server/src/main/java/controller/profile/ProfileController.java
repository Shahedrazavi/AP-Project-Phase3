package controller.profile;

import controller.Controller;
import model.Tweet;
import model.User;

import java.util.LinkedList;

public class ProfileController extends Controller {
    public LinkedList<Tweet> getUserTweets(User user){
        LinkedList<Tweet> list = new LinkedList<>();
        for(Tweet tweet:context.tweets.getAll()) {
            if (tweet.getRetweeterID()!= null){
                if (tweet.getRetweeterID().equals(user.getId())){
                    list.add(tweet);
                }
            }
            if (tweet.getWriterID()!= null){
                if (tweet.getWriterID().equals(user.getId())){
                    list.add(tweet);
                }
            }
        }
        return list;
    }
}
