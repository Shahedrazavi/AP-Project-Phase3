package controller.settings;

import controller.Controller;
import model.User;
import util.Logger;

public class AccountController extends Controller {

    public boolean isPassCorrect(User user , String inputPass){
        return user.getPassword().equals(inputPass);
    }

    public void changePass(User user , String newPass){
        user.setPassword(newPass);
        context.users.update(user);
        Logger.getLogger().passwordChange(user.getUsername(),user.getId().toString());
    }

    public void ChangeAccType(User user, boolean isPublic){
        user.setPublic(isPublic);
        context.users.update(user);
        Logger.getLogger().privacy(user.getUsername(),user.getId().toString(),isPublic);
    }

    public void ChangeLastSeenType(User user, User.LastSeenType lastSeenType){
        user.setLastSeenType(lastSeenType);
        context.users.update(user);
        Logger.getLogger().lastSeenType(user.getUsername(),user.getId().toString(),lastSeenType.toString());
    }

    public void changeActivate(User user){
        user.setActive(!user.isActive());
        context.users.update(user);
        Logger.getLogger().activation(user.getUsername(),user.getId().toString(),user.isActive());
    }

    public void deleteAcc(User user){
        context.users.remove(user);
        Logger.getLogger().delete(user.getUsername(),user.getId().toString());
        Logger.getLogger().logOut(user.getUsername(),user.getId().toString());
    }
}