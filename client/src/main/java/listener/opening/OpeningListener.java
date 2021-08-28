package listener.opening;

import event.opening.OpeningEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class OpeningListener extends Listener {

    public OpeningListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

    public void eventOccurred(OpeningEvent event) {
        if (event.getCommand().equals("registration")){
            graphicalAgent.goToSignUp(event);
        }
        if (event.getCommand().equals("signingIn")){
            graphicalAgent.goToSignIn(event);
        }
    }
}
