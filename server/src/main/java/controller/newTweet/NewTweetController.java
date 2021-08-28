package controller.newTweet;

import controller.Controller;
import event.newTweet.NewTweetEvent;
import model.Tweet;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class NewTweetController extends Controller {

    public void Tweet(NewTweetEvent event){
        LocalDateTime localDateTime = LocalDateTime.now();
        context.tweets.increaseLastID();
        Tweet tweet = new Tweet(context.tweets.getLastID(),event.getText(),null, localDateTime,localDateTime,
                event.getLoggedInUser().getId(),null,new LinkedList<>(),new LinkedList<>(),new LinkedList<>(),
                null,null);
        context.tweets.add(tweet);
    }
}
