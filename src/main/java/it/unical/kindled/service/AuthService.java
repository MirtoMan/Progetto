package it.unical.kindled.service;

import it.unical.kindled.dao.UserDAO;
import it.unical.kindled.model.User;
import it.unical.kindled.security.PasswordUtil;
import java.time.LocalDateTime;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    public boolean register (String username, String password, String email) {
        if (userDAO.findByUsername(username) != null) {
            return false;
        }

        String hashPassword = PasswordUtil.hash(password);

        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(hashPassword);
        user.setEmail(email);
        user.setCreatedAt(LocalDateTime.now().toString());

        userDAO.insert(user);
        return true;
    }

    public User login(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user == null) return null;

        if (PasswordUtil.verify(password, user.getPasswordHash())) {
            return user;
        }
        return null;
    }
}
