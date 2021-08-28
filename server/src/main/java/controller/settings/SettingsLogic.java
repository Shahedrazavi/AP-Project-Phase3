package controller.settings;

import config.Config;
import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import event.settings.SettingsStringEvent;
import model.User;
import response.EmptyResponse;
import response.Response;
import response.settings.ChangeActResponse;
import response.settings.ChangePassResponse;
import response.settings.DeleteAccResponse;

public class SettingsLogic {

    private AccountController accountController;

    public SettingsLogic() {
        accountController = new AccountController();
    }

    public Response checkForChangingPass(ChangePassEvent changePassEvent){
        ChangePassResponse response = new ChangePassResponse();
        boolean isValid = accountController.isPassCorrect(changePassEvent.getUser(),changePassEvent.getCurrentPass());
        response.setValid(isValid);

        if (isValid){
            accountController.changePass(changePassEvent.getUser(), changePassEvent.getNewPass());
        }
        return response;
    }

    public Response changeAccType(ComboBoxEvent event){
        boolean isPublic = event.getSelectedOption().equals(Config.getConfig("settings").getProperty("public"));
        accountController.ChangeAccType(event.getUser(),isPublic);
        return new EmptyResponse();
    }

    public Response changeLastSeenType(ComboBoxEvent event){
        User.LastSeenType lastSeenType = User.LastSeenType.everyone;
        if (event.getSelectedOption().equals(Config.getConfig("settings").getProperty("follow"))){
            lastSeenType = User.LastSeenType.followings;
        }
        if (event.getSelectedOption().equals(Config.getConfig("settings").getProperty("no_one"))){
            lastSeenType = User.LastSeenType.no_one;
        }
        accountController.ChangeLastSeenType(event.getUser(), lastSeenType);
        return new EmptyResponse();
    }

    public Response changeActivate(SettingsStringEvent event){
        accountController.changeActivate(event.getUser());
//        SettingsFXMLController settingsFXMLController = (SettingsFXMLController) event.getSource();
//        settingsFXMLController.update();
        //
        return new ChangeActResponse();
    }

    public Response deleteAcc(SettingsStringEvent event){

        accountController.deleteAcc(event.getUser());
        return new DeleteAccResponse();
    }
}
