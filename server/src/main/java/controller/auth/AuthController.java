package controller.auth;

import controller.Controller;
import event.auth.registration.RegistrationFormEvent;
import model.User;
import util.Logger;
//import util.Logger;

import java.time.LocalDate;

public class AuthController extends Controller {

    public void register(RegistrationFormEvent formEvent, LocalDate birthday){
        context.users.increaseLastID();
        User newUser = new User(context.users.getLastID(),formEvent.getUsername(),formEvent.getPassword1(),
                formEvent.getProfileName(),formEvent.getFirstName(),formEvent.getLastName(),
                formEvent.getEmail(),formEvent.getPhoneNumber(),birthday);
        context.users.add(newUser);
        Logger.getLogger().signUp(newUser.getUsername(),newUser.getId().toString());
    }

    public void registerWithoutBirthday(RegistrationFormEvent formEvent){
        context.users.increaseLastID();
        User newUser = new User(context.users.getLastID(),formEvent.getUsername(),formEvent.getPassword1(),
                formEvent.getProfileName(),formEvent.getFirstName(),formEvent.getLastName(),
                formEvent.getEmail(),formEvent.getPhoneNumber());
        context.users.add(newUser);
        Logger.getLogger().signUp(newUser.getUsername(),newUser.getId().toString());
    }

    public boolean isUsernameAvailable(String username) {
        if (context.users.getAll()==null){
            return true;
        }
        return !context.users.getAll().stream().anyMatch(user -> user.getUsername().equals(username));
    }

    public boolean isEmailAvailable(String email){
        if (context.users.getAll()==null){
            return true;
        }
        return !context.users.getAll().stream().anyMatch(user -> user.getEmail().equals(email));
    }
}
