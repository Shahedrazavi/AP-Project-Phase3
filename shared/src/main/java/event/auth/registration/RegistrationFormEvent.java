package event.auth.registration;

import event.Event;

import java.time.LocalDate;
import java.util.LinkedList;

public class RegistrationFormEvent extends Event {

    private LinkedList<String> firstPageInfo;

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password1;
    private String password2;

    private String birthdayYear;
    private String birthdayMonth;
    private String birthdayDay;
    private String phoneNumber;
    private String profileName;

    private RegFormEventLevel level;

    public enum RegFormEventLevel{
        FIRST,
        LAST
    }


    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public RegistrationFormEvent(Object source, String firstName , String lastName , String email , String username , String password1 , String password2) {
        super(source);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.level = RegFormEventLevel.FIRST;

        firstPageInfo = new LinkedList<>();
        firstPageInfo.add(firstName);
        firstPageInfo.add(lastName);
        firstPageInfo.add(email);
        firstPageInfo.add(username);
        firstPageInfo.add(password1);
        firstPageInfo.add(password2);
    }

    public void setBirthdayYear(String birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public void setBirthdayDay(String birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLevel(RegFormEventLevel level) {
        this.level = level;
    }

    public RegFormEventLevel getLevel() {
        return level;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }


    public LinkedList<String> getFirstPageInfo() {
        return firstPageInfo;
    }


}
