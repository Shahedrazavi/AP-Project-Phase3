package event;

import event.auth.registration.RegistrationFormEvent;
import event.auth.signIn.SignInFormEvent;
import event.opening.OpeningEvent;
import response.Response;

public interface EventVisitor {
    Response open(OpeningEvent event);
    Response signInCheck(SignInFormEvent formEvent);
    Response regInfoCheck1(RegistrationFormEvent formEvent);
    Response regInfoCheck2(RegistrationFormEvent formEvent);
}
