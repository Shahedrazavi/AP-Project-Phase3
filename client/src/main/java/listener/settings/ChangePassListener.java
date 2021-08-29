package listener.settings;

import event.settings.ChangePassEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class ChangePassListener extends Listener {

    public ChangePassListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

    public void eventOccurred(ChangePassEvent event){
        graphicalAgent.getListener().listen(event);
    }
}
