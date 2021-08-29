package event.component.tweetComponent;

import event.EventVisitor;
import event.StringEvent;
import model.User;
import response.Response;

public class TweetEvent extends StringEvent {
    private User loggedInUser;

    public TweetEvent(Object source, String command , User loggedInUser) {
        super(source, command);
        this.loggedInUser = loggedInUser;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        if (getCommand().equals("likePressed")) return eventVisitor.likeTweet();
        if (getCommand().equals("reportPressed")) return eventVisitor.reportTweet();
//        if (getCommand().equals("retweetPressed"))
//        if (getCommand().equals("savePressed"))
//        if (getCommand().equals("viewCommentsPressed"))
//        if (getCommand().equals(""))
//        if (getCommand().equals(""))
//        if (getCommand().equals(""))
//        if (getCommand().equals(""))
        return null;
    }
}
