package controller.auth.signIn;

import event.auth.signIn.SignInFormEvent;
import model.User;
import response.Response;
import response.auth.signIn.SignInResponse;
import ui.auth.signIn.SignInCenterFXMLController;
import util.Logger;

public class SignInPageLogic {
    private SignInResponse response;
    private SignInController signInController;

    public SignInPageLogic() {
        this.signInController = new SignInController();
    }

    public Response check(SignInFormEvent formEvent){
        boolean isValid = isInfoCorrect(formEvent);

//        SignInCenterFXMLController controller = (SignInCenterFXMLController) formEvent.getSource();
//        controller.getErrorLabel().setVisible(!isValid);

        if (isValid){
            response.setSignedInUser(logIn(formEvent));
        }

        response.setValid(isValid);

        return response;
    }

    public boolean isInfoCorrect(SignInFormEvent formEvent){

        boolean isValid = true;

        isValid = isInfoNotEmpty(formEvent);

        if (isValid){
            isValid = signInController.doesUsernameExist(formEvent.getUsername());
        }

        if (isValid){
            isValid = signInController.doesUserPassMatch(formEvent.getUsername(), formEvent.getPassword());
        }

        return isValid;
    }

    public boolean isInfoNotEmpty(SignInFormEvent formEvent){
        if (formEvent.getUsername().isEmpty()){
            return false;
        }
        if (formEvent.getPassword().isEmpty()){
            return false;
        }

        return true;
    }

    public User logIn(SignInFormEvent formEvent){
        return signInController.getUser(formEvent.getUsername());

//        SignInCenterFXMLController controller = (SignInCenterFXMLController) formEvent.getSource();
//        Logger.getLogger().signIn(loggedInUser.getUsername(),loggedInUser.getId().toString());
//        controller.goToHomePage(loggedInUser);
    }
}
