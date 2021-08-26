package event.component.tweetViewer;

import event.StringEvent;

public class TweetViewerEvent extends StringEvent {
    public TweetViewerEvent(Object source, String command) {
        super(source, command);
    }
}
