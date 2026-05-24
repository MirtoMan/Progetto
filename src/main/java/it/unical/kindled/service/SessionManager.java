package it.unical.kindled.service;

import it.unical.kindled.model.User;

public final class SessionManager {
    private static User loggedUser;
    private static SessionManager instance = new SessionManager();
    private SessionManager() {}

    public static SessionManager getInstance() {return instance;}

    public void setLoggedUser(User user) {
        loggedUser = user;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void clearSession() {
        loggedUser = null;
    }

    public boolean isLoggedIn() {
        return loggedUser != null;
    }
}
