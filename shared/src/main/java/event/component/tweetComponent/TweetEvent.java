package event.component.tweetComponent;

import event.StringEvent;

public class TweetEvent extends StringEvent {
    public TweetEvent(Object source, String command) {
        super(source, command);
    }


}
