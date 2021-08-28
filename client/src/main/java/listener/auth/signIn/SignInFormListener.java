package listener.auth.signIn;

//import controller.auth.signIn.SignInPageLogic;
import event.auth.signIn.SignInFormEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class SignInFormListener extends Listener {

    public SignInFormListener(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

    public void eventOccurred(SignInFormEvent formEvent){
//        logic.check(formEvent);
        graphicalAgent.getListener().listen(formEvent);
    }
}
