package controller.auth.registration;

import controller.auth.AuthController;
import event.auth.registration.RegistrationFormEvent;
import response.Response;
import response.auth.registration.RegPage2Response;

import java.time.DateTimeException;
import java.time.LocalDate;

public class RegistrationPage2Logic {
    private RegPage2Response response;
    private AuthController authController;

    public RegistrationPage2Logic() {
        authController = new AuthController();
        response = new RegPage2Response();
    }

    public Response check(RegistrationFormEvent formEvent){
        boolean isValid = isBirthdayValid(formEvent);
        if (isValid){
            setProfileName(formEvent);
            try{
                authController.register(formEvent,
                        LocalDate.of(Integer.parseInt(formEvent.getBirthdayYear()),
                                Integer.parseInt(formEvent.getBirthdayMonth()),
                                Integer.parseInt(formEvent.getBirthdayDay())));
            }
            catch (NumberFormatException e){
                authController.registerWithoutBirthday(formEvent);
            }
        }

        response.setValid(isValid);

        return response;
    }

    public boolean isBirthdayValid(RegistrationFormEvent formEvent){
        LocalDate birthday = LocalDate.now();

        boolean isValid = true;

        try {
            birthday = LocalDate.of(Integer.parseInt(formEvent.getBirthdayYear()),
                    Integer.parseInt(formEvent.getBirthdayMonth()),
                    Integer.parseInt(formEvent.getBirthdayDay()));
        }
        catch (NumberFormatException ignored){
        }
        catch (DateTimeException e){
            isValid = false;
        }
        return isValid;
    }

    public void setProfileName(RegistrationFormEvent formEvent){
        if (formEvent.getProfileName().isEmpty()){
            formEvent.setProfileName(formEvent.getUsername());
        }
    }

}
