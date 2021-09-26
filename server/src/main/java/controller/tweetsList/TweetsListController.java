package controller.tweetsList;

import controller.Controller;
import model.ID;
import model.Tweet;
import model.User;

import javax.swing.plaf.LabelUI;
import java.util.LinkedList;

public class TweetsListController extends Controller {
    public LinkedList<Tweet> getUserTweets(User loggedInUser , User targetUser){
        LinkedList<Tweet> list = new LinkedList<>();
        if (loggedInUser.equals(targetUser)){
            return getAllUserTweets(targetUser);
        }
        else {
            if (targetUser.getBlockedUsers().contains(loggedInUser.getId())) {
                return list;
            }

            boolean canSee = true;
            if (!targetUser.isPublic()) {
                canSee = targetUser.getFollowers().contains(loggedInUser.getId());
            }

            if (!canSee) {
                return list;
            }
            return getAllUserTweets(targetUser);
        }
    }

    public LinkedList<Tweet> getExploreTweets(){
        LinkedList<Tweet> tweets = new LinkedList<>();
        for (User user : context.users.getAll()){
            if (user.isPublic()){
                tweets.addAll(getAllUserTweets(user));
            }
        }
        return tweets;
    }

    public LinkedList<Tweet> getTimeLineTweets(User loggedInUser){
        LinkedList<User> following = new LinkedList<>();
        for (ID id :loggedInUser.getFollowing()){
            following.add(context.users.get(id));
        }

        LinkedList<Tweet> tweets = new LinkedList<>();
        for (User user : following){
            if (user.isPublic()){
                tweets.addAll(getAllUserTweets(user));
            }
        }
        return tweets;
    }

    public LinkedList<Tweet> getComments(User loggedInUser , Tweet targetTweet){
        LinkedList<Tweet> comments = new LinkedList<>();
        for (ID id : targetTweet.getComments()){
            comments.add(context.tweets.get(id));
        }

        LinkedList<Tweet> tweets = new LinkedList<>();
        for (Tweet tweet : comments){
            User targetUser = context.users.get(tweet.getWriterID());
            if (!targetUser.getBlockedUsers().contains(loggedInUser.getId())) {
                boolean canSee = true;
                if (!targetUser.isPublic()) {
                    canSee = targetUser.getFollowers().contains(loggedInUser.getId());
                }
                if (canSee) tweets.add(tweet);
            }
        }
        return tweets;
    }



    public LinkedList<Tweet> getAllUserTweets(User targetUser){
        LinkedList<Tweet> list = new LinkedList<>();
        for(Tweet tweet:context.tweets.getAll()) {
            if (tweet.getRetweeterID()!= null){
                if (tweet.getRetweeterID().equals(targetUser.getId())){
                    //Bug dare :))))) //
                    list.add(tweet);
                }
            }
            if (tweet.getWriterID()!= null){
                if (tweet.getWriterID().equals(targetUser.getId())){
                    list.add(tweet);
                }
            }
        }
        return list;
    }
}
