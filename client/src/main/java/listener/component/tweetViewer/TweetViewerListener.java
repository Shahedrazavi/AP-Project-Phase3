package listener.component.tweetViewer;

import event.component.tweetViewer.TweetViewerEvent;
import listener.Listener;
import ui.GraphicalAgent;
import ui.component.tweetViewer.TweetViewerFXMLController;

public class TweetViewerListener extends Listener {
    public TweetViewerListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }
//    private TweetViewerLogic logic;

//    public TweetViewerListener(TweetViewerLogic logic) {
//        this.logic = logic;
//    }


    public void EventOccurred(TweetViewerEvent event){
        if (event.getCommand().equals("nextPressed")){
            ((TweetViewerFXMLController)event.getSource()).getComponent().goToNext();
        }
        if (event.getCommand().equals("previousPressed")){
            ((TweetViewerFXMLController)event.getSource()).getComponent().goToPrevious();
        }
    }
}
