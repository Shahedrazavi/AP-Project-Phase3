package model;

public class Notif extends Model {
    private ID notifMakerUser;
    private NotifType notifType;

    enum NotifType {
        REQUEST,
        REQUEST_ACC,
        FOLLOW,
        UNFOLLOW
    }

    public Notif(ID id, ID notifMakerUser, NotifType notifType) {
        super(id);
        this.notifMakerUser = notifMakerUser;
        this.notifType = notifType;
    }
}
