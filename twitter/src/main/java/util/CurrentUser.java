package util;

import domain.User;

public class CurrentUser {
    private static User currentUser;

    private CurrentUser() {
    }

    public static User getUser() {
        return currentUser;
    }

    public static void setUserNull() {
        currentUser = null;
    }

    public static void setCurrentUser(User user) {
       currentUser= user;
    }
}
