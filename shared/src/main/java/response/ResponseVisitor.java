package response;

import response.auth.registration.RegPage1Response;
import response.auth.registration.RegPage2Response;
import response.auth.signIn.SignInResponse;

public interface ResponseVisitor {
    void finalizeRegPage1(RegPage1Response response);
    void finalizeRegPage2(RegPage2Response response);
    void finalizeSignIn(SignInResponse response);
}
