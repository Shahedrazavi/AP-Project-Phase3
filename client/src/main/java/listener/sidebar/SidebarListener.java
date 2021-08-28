package listener.sidebar;

import event.StringEvent;
import ui.sidebar.SidebarFXMLController;

public class SidebarListener {

    public void eventOccurred(StringEvent event) {
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
        if (event.getCommand().equals("profile")){
            ((SidebarFXMLController)event.getSource()).getComponent().goToSelfProfile();
        }
        if (event.getCommand().equals("settings")){
            ((SidebarFXMLController)event.getSource()).getComponent().goToSettings();
        }
        if (event.getCommand().equals("logout")){
            ((SidebarFXMLController)event.getSource()).getComponent().exitToHomePage();
        }
        if (event.getCommand().equals("tweet")){
            ((SidebarFXMLController)event.getSource()).getComponent().goToNewTweet();
        }
        if (event.getCommand().equals("back")){
            ((SidebarFXMLController)event.getSource()).getComponent().goBack();
        }
    }
}
