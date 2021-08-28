package controller.auth.signIn;

import controller.Controller;
import model.User;

public class SignInController extends Controller {


    public boolean doesUsernameExist(String username){
        if (context.users.getAll()==null){
            return false;
        }
        return context.users.getAll().stream().anyMatch(user -> user.getUsername().equals(username));
    }

    public boolean doesUserPassMatch(String username , String password){
        if (context.users.getAll()==null){
            return false;
        }

        return context.users.getAll().stream().anyMatch(user -> username.equals(user.getUsername()) &&
                password.equals(user.getPassword()));
    }

    public User getUser(String username){
        for (User user : context.users.getAll()){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}
