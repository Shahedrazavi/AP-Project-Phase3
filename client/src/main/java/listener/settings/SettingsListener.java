package listener.settings;

import event.settings.SettingsStringEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class SettingsListener extends Listener {

    public SettingsListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

    public void eventOccurred(SettingsStringEvent event) {
        if (event.getCommand().equals("delete")) {
//            logic.deleteAcc(event);
        }
        if (event.getCommand().equals("deactivate")) {
//            logic.changeActivate(event);
        }
    }
}
