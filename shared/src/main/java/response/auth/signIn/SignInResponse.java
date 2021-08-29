package response.auth.signIn;

import model.User;
import response.Response;
import response.ResponseVisitor;

public class SignInResponse extends Response {
    private boolean isValid;
    private User signedInUser;
    private int token;

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.finalizeSignIn(this);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public User getSignedInUser() {
        return signedInUser;
    }

    public void setSignedInUser(User signedInUser) {
        this.signedInUser = signedInUser;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }
}
