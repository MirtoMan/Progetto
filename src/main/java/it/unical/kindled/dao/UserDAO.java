package it.unical.kindled.dao;
import it.unical.kindled.database.DatabaseManager;
import it.unical.kindled.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void insert(User user) {
        String sql = "INSERT INTO users(username, password_hash, email, created_at) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCreatedAt());

            stmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DatabaseManager.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                return mapUser(res);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findById(int id ) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                return mapUser(res);
            }


        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (
                Connection conn = DatabaseManager.connect();
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery(sql);
                ) {
            while (res.next()) {
                list.add(mapUser(res));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    private User mapUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPasswordHash(rs.getString("password_hash"));
        u.setEmail(rs.getString("email"));
        u.setCreatedAt(rs.getString("created_at"));
        return u;
    }
}
