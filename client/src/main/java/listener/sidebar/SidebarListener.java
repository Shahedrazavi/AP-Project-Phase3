package listener.sidebar;

import event.sidebar.SidebarEvent;
import listener.Listener;
import ui.GraphicalAgent;
import ui.sidebar.SidebarFXMLController;

public class SidebarListener extends Listener {

    public SidebarListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

    public void eventOccurred(SidebarEvent event) {
        if (event.getCommand().equals("back")){
            ((SidebarFXMLController)event.getSource()).getComponent().goBack();
        }
        if (event.getCommand().equals("tweet")){
            ((SidebarFXMLController)event.getSource()).getComponent().goToNewTweet();
        }
        if (event.getCommand().equals("settings")){
            ((SidebarFXMLController)event.getSource()).getComponent().goToSettings();
        }
        if (event.getCommand().equals("profile")){
            ((SidebarFXMLController)event.getSource()).getComponent().goToSelfProfile();
        }
        if (event.getCommand().equals("timeline")){

        }
        if (event.getCommand().equals("explore")){

        }
        if (event.getCommand().equals("notifs")){

        }
        if (event.getCommand().equals("search")){

        }
        if (event.getCommand().equals("messages")){

        }
        else {
            graphicalAgent.getListener().listen(event);
        }
    }
}
