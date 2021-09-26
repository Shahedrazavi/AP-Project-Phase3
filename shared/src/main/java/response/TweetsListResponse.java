package response;

import model.Tweet;

import java.util.LinkedList;

public class TweetsListResponse extends StringResponse{
    private LinkedList<Tweet> tweets;

    public TweetsListResponse(String command , LinkedList<Tweet> tweets) {
        super(command);
        this.tweets = tweets;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.receiveTweetList(this);
    }

    public LinkedList<Tweet> getTweets() {
        return tweets;
    }
}
