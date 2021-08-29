package ui.sidebar;

import model.User;
import ui.Component;
import ui.GraphicalAgent;
import ui.mainView.MainPage;

public class Sidebar extends Component {

    public Sidebar(String fxmlName, GraphicalAgent graphicalAgent, MainPage parent , User user) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        setLoggedInUser(user);
        initialize();
    }

    @Override
    public void initialize() {
        SidebarFXMLController controller = (SidebarFXMLController)fxmlController;
        controller.setComponent(this);
        controller.setListener();
        update();
    }

    @Override
    public void update() {
        ((SidebarFXMLController)fxmlController).hideOrUnhideButtons();
    }

//    public void exitToHomePage(){
//        ((MainPage)parent).exit();
//    }

    public void goBack(){
        ((MainPage)parent).goBack();
    }

    public void goToSelfProfile(){
        ((MainPage)parent).goToProfilePage(loggedInUser);
    }

    public void goToSettings(){
        ((MainPage)parent).goToSettingsPage();
    }

    public void goToNewTweet(){
        ((MainPage)parent).goToNewTweetPage();
    }

}
