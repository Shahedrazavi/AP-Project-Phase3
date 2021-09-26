package controller.tweetsList;

import model.Tweet;
import model.User;
import response.TweetsListResponse;

import java.util.LinkedList;

public class TweetsListLogic {

    private TweetsListController controller;


    public TweetsListLogic() {
        controller = new TweetsListController();
    }


    public TweetsListResponse getUserTweets(User loggedInUser , User targetUser){
        return new TweetsListResponse("profile",controller.getUserTweets(loggedInUser,targetUser));
    }

    public TweetsListResponse getTimeline(User loggedInUser){
        return new TweetsListResponse("timeline",controller.getTimeLineTweets(loggedInUser));
    }

    public TweetsListResponse getExplore(){
        return new TweetsListResponse("explore",controller.getExploreTweets());
    }

    public TweetsListResponse getCommentTweets(User loggedInUser , Tweet targetTweet){
        return new TweetsListResponse("comments",controller.getComments(loggedInUser,targetTweet));
    }
}
