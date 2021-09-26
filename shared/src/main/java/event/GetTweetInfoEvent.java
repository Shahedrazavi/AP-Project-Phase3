package event;

import model.Tweet;
import response.Response;

public class GetTweetInfoEvent extends Event{
    private Tweet tweet;

    public GetTweetInfoEvent(Object source , Tweet tweet) {
        super(source);
        this.tweet= tweet;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.getTweetInfo(this);
    }

    public Tweet getTweet() {
        return tweet;
    }
}
