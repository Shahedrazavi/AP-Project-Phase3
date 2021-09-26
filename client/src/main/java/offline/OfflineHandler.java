package offline;

import event.AccountEvent;
import event.EventVisitor;
import event.GetTweetInfoEvent;
import event.GetTweetsEvent;
import event.auth.registration.RegistrationFormEvent;
import event.auth.signIn.SignInFormEvent;
import event.component.tweetComponent.TweetEvent;
import event.newTweet.NewTweetEvent;
import event.opening.OpeningEvent;
import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import event.settings.SettingsStringEvent;
import model.User;
import response.EmptyResponse;
import response.Response;

public class OfflineHandler implements EventVisitor {
    @Override
    public Response open(OpeningEvent openingEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response signInCheck(SignInFormEvent signInFormEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response regInfoCheck1(RegistrationFormEvent registrationFormEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response regInfoCheck2(RegistrationFormEvent registrationFormEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response logOut(User user) {
        return new EmptyResponse();
    }

    @Override
    public Response newTweet(NewTweetEvent newTweetEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response changePass(ChangePassEvent changePassEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response deleteAcc(SettingsStringEvent settingsStringEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response deactivateAcc(SettingsStringEvent settingsStringEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response changeAccType(ComboBoxEvent comboBoxEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response changeLastSeen(ComboBoxEvent comboBoxEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response likeTweet(TweetEvent tweetEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response showComments(TweetEvent tweetEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response reportTweet(TweetEvent tweetEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response retweetTweet(TweetEvent tweetEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response savePressed(TweetEvent tweetEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response blockAcc(AccountEvent accountEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response muteAcc(AccountEvent accountEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response viewProfile(AccountEvent accountEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response getTweetsList(GetTweetsEvent getTweetsEvent) {
        return new EmptyResponse();
    }

    @Override
    public Response getTweetInfo(GetTweetInfoEvent getTweetInfoEvent) {
        return new EmptyResponse();
    }
}
