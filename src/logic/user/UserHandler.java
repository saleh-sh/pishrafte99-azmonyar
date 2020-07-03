package logic.user;

public class UserHandler {

    private static User onlineUser;

    public static void setOnlineUser(User onlineUser) {
        UserHandler.onlineUser = onlineUser;
    }

    public static User getOnlineUser() {
        return onlineUser;
    }
}
