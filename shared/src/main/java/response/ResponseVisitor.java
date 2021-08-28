package response;

import response.auth.registration.RegPage1Response;
import response.auth.registration.RegPage2Response;
import response.auth.signIn.SignInResponse;
import response.newTweet.NewTweetResponse;
import response.settings.ChangePassResponse;

public interface ResponseVisitor {
    void getEmptyResponse();
    void finalizeRegPage1(RegPage1Response response);
    void finalizeRegPage2(RegPage2Response response);
    void finalizeSignIn(SignInResponse response);
    void logOut();
    void goBackFromNewTweet(NewTweetResponse response);
    void changePass(ChangePassResponse changePassResponse);
    void activation();
    void deleteAcc();
}
