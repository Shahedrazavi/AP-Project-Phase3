package listener.newTweet;

import event.newTweet.NewTweetEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class NewTweetListener extends Listener {
    public NewTweetListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }
//    NewTweetLogic logic;

    public void eventOccurred(NewTweetEvent event){
        if (event.getCommand().equals("tweet")){
            graphicalAgent.getListener().listen(event);
//            logic.checkForTweet(event);
        }
    }
}
