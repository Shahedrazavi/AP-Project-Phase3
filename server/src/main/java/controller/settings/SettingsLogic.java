package controller.settings;

import config.Config;
import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import event.settings.SettingsStringEvent;
import model.User;
import ui.settings.SettingsFXMLController;

public class SettingsLogic {

//    private AccountController accountController;

    public SettingsLogic() {
        accountController = new AccountController();
    }

    public void checkForChangingPass(ChangePassEvent changePassEvent){
        boolean isValid = accountController.isPassCorrect(changePassEvent.getUser(),changePassEvent.getCurrentPass());


        /* These part need to be completely revised in phase3 */
//        SettingsFXMLController settingsFXMLController = (SettingsFXMLController) changePassEvent.getSource();
//        settingsFXMLController.getPassErrorLabel().setVisible(!isValid);

        if (isValid){
//            accountController.changePass(changePassEvent.getUser(), changePassEvent.getNewPass());
        }
    }

    public void ChangeAccType(ComboBoxEvent event){
        boolean isPublic = event.getSelectedOption().equals(Config.getConfig("settings").getProperty("public"));
//        accountController.ChangeAccType(event.getUser(),isPublic);
    }

    public void ChangeLastSeenType(ComboBoxEvent event){
        User.LastSeenType lastSeenType = User.LastSeenType.everyone;
        if (event.getSelectedOption().equals(Config.getConfig("settings").getProperty("follow"))){
            lastSeenType = User.LastSeenType.followings;
        }
        if (event.getSelectedOption().equals(Config.getConfig("settings").getProperty("no_one"))){
            lastSeenType = User.LastSeenType.no_one;
        }
//        accountController.ChangeLastSeenType(event.getUser(), lastSeenType);
    }

    public void changeActivate(SettingsStringEvent event){
//        accountController.changeActivate(event.getUser());
//        SettingsFXMLController settingsFXMLController = (SettingsFXMLController) event.getSource();
//        settingsFXMLController.update();
        //
    }

    public void deleteAcc(SettingsStringEvent event){
//        accountController.deleteAcc(event.getUser());
//        SettingsFXMLController settingsFXMLController = (SettingsFXMLController) event.getSource();
//        settingsFXMLController.deleteAndExit();
        //
    }
}
