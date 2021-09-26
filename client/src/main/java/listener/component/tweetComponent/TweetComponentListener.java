package listener.component.tweetComponent;

import event.AccountEvent;
import event.component.tweetComponent.TweetEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class TweetComponentListener extends Listener {
    public TweetComponentListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

//    TweetComponentLogic logic;

//    public TweetComponentListener(TweetComponentLogic logic) {
//        this.logic = logic;
//    }

    public void eventOccurred(TweetEvent event){
        if (event.getCommand().equals("commentPressed")){
        }
        if (event.getCommand().equals("viewCommentsPressed")){
            graphicalAgent.getMainPage().goToComments(event.getTweet());
        }
        if (event.getCommand().equals("viewTweetPhotoPressed")){
//            logic.viewTweetPhoto();
        }
        if (event.getCommand().equals("forwardPressed")){
//            logic.forwardTo();
        }

        else graphicalAgent.getListener().listen(event);
    }

    public void eventOccurred(AccountEvent event){
        graphicalAgent.getListener().listen(event);
    }
}
