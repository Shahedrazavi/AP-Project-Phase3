package response.newTweet;

import response.Response;
import response.ResponseVisitor;

public class NewTweetResponse extends Response {
    private boolean isValid;

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.goBackFromNewTweet(this);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}