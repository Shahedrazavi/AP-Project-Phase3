package event;

import event.auth.registration.RegistrationFormEvent;
import event.auth.signIn.SignInFormEvent;
import event.newTweet.NewTweetEvent;
import event.opening.OpeningEvent;
import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import event.settings.SettingsStringEvent;
import model.User;
import response.Response;

public interface EventVisitor {
    Response open(OpeningEvent event);
    Response signInCheck(SignInFormEvent formEvent);
    Response regInfoCheck1(RegistrationFormEvent formEvent);
    Response regInfoCheck2(RegistrationFormEvent formEvent);
    Response logOut(User loggedInUser);
    Response newTweet(NewTweetEvent newTweetEvent);
    Response changePass(ChangePassEvent changePassEvent);
    Response deleteAcc(SettingsStringEvent settingsStringEvent);
    Response deactivateAcc(SettingsStringEvent settingsStringEvent);
    Response changeAccType(ComboBoxEvent comboBoxEvent);
    Response changeLastSeen(ComboBoxEvent comboBoxEvent);
}
