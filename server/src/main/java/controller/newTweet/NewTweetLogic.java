package controller.newTweet;

import event.newTweet.NewTweetEvent;
import response.Response;
import response.newTweet.NewTweetResponse;

public class NewTweetLogic {
    private NewTweetResponse response;
    private NewTweetController controller;

    public NewTweetLogic() {
        controller = new NewTweetController();
        response = new NewTweetResponse();
    }

    public Response checkForTweet(NewTweetEvent event){
        response.setValid(false);
        if (!(event.getText().equals("")) || event.getImage()!=null){
            controller.Tweet(event);
            response.setValid(true);
        }
        return response;
    }
}
