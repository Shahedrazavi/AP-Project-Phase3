package ui.component.tweetComponent;


//import controller.component.tweetComponent.TweetComponentLogic;
import model.Tweet;
import model.User;
import ui.Component;
import ui.GraphicalAgent;
import ui.component.tweetViewer.TweetViewer;

public class TweetComponent extends Component {
    private Tweet tweet;
    private User loggedInUser;
//    private TweetComponentLogic logic;

    public TweetComponent(String fxmlName, GraphicalAgent graphicalAgent, TweetViewer parent, Tweet tweet , User loggedInUser) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        setLoggedInUser(loggedInUser);
        this.tweet = tweet;
        this.loggedInUser = loggedInUser;
//        this.logic = new TweetComponentLogic(this,tweet,loggedInUser);
        initialize();
    }

    @Override
    public void initialize() {
        TweetComponentFXMLController controller = (TweetComponentFXMLController) fxmlController;
        controller.setComponent(this);
//        controller.initializeLogic(logic);
        controller.initializeListener();
        controller.setTweetInfo();
        controller.configButtons();
    }

    public void goToProfile(User user){
        ((TweetViewer)parent).goToProfile(user);
    }

    public Tweet getTweet() {
        return tweet;
    }
}
