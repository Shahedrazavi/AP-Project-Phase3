package controller.auth.registration;

import controller.auth.AuthController;
import event.auth.registration.RegistrationFormEvent;
import response.Response;
import response.auth.registration.RegPage1Response;

import java.util.LinkedList;

public class RegistrationPage1Logic {
    private RegPage1Response response;
    private AuthController authController;

    public RegistrationPage1Logic() {
        authController = new AuthController();
        response = new RegPage1Response();
    }

    public Response check(RegistrationFormEvent event){

        boolean isBlank = true;
        boolean isValid = isFirstLevelNotEmpty(event);
        if (isValid){
            isValid = isFirstLevelValid(event);
            isBlank = false;
        }


        response.setValid(isValid);
        response.setBlank(isBlank);
        return response;

    }
    public boolean isFirstLevelNotEmpty(RegistrationFormEvent event){
//        RegistrationPage1FXMLController controller = (RegistrationPage1FXMLController) event.getSource();

        LinkedList<String> eventInfo = event.getFirstPageInfo();

//        LinkedList<Label> emptyErrorLabels = controller.getFirstPageEmptyErrors();

//        LinkedList<Boolean> isLabelWritten = new LinkedList<>();

        boolean isValid = true;

        for (int i = 0 ; i<6 ; i++){
            if (eventInfo.get(i).isEmpty()){
                response.getEmptyErrorLabels().add(false);
                isValid = false;
            }else {
                response.getEmptyErrorLabels().add(true);
            }
        }

//        for (int i = 0 ; i<6 ; i++){
//            if (isLabelWritten.get(i)){
//                controller.hideLabel(emptyErrorLabels.get(i));
//            }else {
//                controller.showLabel(emptyErrorLabels.get(i));
//            }
//        }

        return isValid;
    }

    public boolean isFirstLevelValid(RegistrationFormEvent event){
//        RegistrationPage1FXMLController controller = (RegistrationPage1FXMLController) event.getSource();

        boolean isPasswordMatched = true;
        boolean isUsernameAvailable = authController.isUsernameAvailable(event.getUsername());
        boolean isEmailAvailable = authController.isEmailAvailable(event.getEmail());


//        if (!event.getPassword1().equals(event.getPassword2())){
//            isPasswordMatched = false;
//            controller.showLabel(controller.getPasswordError());
//        } else {
//            controller.hideLabel(controller.getPasswordError());
//        }

        if (!event.getPassword1().equals(event.getPassword2())){
            response.getErrorLabels().add(false);
        }
        else {
            response.getErrorLabels().add(true);
        }


//        if (!isEmailAvailable){
//            controller.showLabel(controller.getEmailError());
//        } else{
//            controller.hideLabel(controller.getEmailError());
//        }
        if (!isEmailAvailable){
            response.getErrorLabels().add(false);
        }
        else {
            response.getErrorLabels().add(true);
        }

//        if (!isUsernameAvailable){
//            controller.showLabel(controller.getUsernameError());
//        } else {
//            controller.hideLabel(controller.getUsernameError());
//        }
        if (!isUsernameAvailable){
            response.getErrorLabels().add(false);
        }
        else {
            response.getErrorLabels().add(true);
        }

        return (isPasswordMatched&&isEmailAvailable&&isUsernameAvailable);
    }

//    public void proceed(RegistrationFormEvent event){
//        RegistrationPage1FXMLController controller = (RegistrationPage1FXMLController) event.getSource();
//        controller.goToPage2(event);
//    }
}
