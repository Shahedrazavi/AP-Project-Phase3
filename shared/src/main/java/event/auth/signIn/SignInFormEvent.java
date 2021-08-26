package event.auth.signIn;

import event.Event;

public class SignInFormEvent extends Event {

    private String username;
    private String password;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public SignInFormEvent(Object source , String username , String password) {
        super(source);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
