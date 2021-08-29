package listener.settings;

import event.settings.ComboBoxEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class ComboBoxListener extends Listener {

    public ComboBoxListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

    public void eventOccurred(ComboBoxEvent event){
        if (event.getCommand().equals("changeAccountType")){
            graphicalAgent.getListener().listen(event);
        }
        if (event.getCommand().equals("changeLastSeen")) {
            graphicalAgent.getListener().listen(event);
        }
    }

}
