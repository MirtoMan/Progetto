package it.unical.kindled.database;

import it.unical.kindled.dao.UserDAO;
import it.unical.kindled.model.User;
import it.unical.kindled.security.PasswordUtil;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;

public class DatabaseInitializer {

    public static void initialize() {

        String usersTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                password_hash TEXT NOT NULL,
                email TEXT,
                created_at TEXT
            );
        """;

        String booksTable = """
            CREATE TABLE IF NOT EXISTS books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                author TEXT,
                file_path TEXT NOT NULL,
                cover_path TEXT,
                added_at TEXT,
                user_id INTEGER,

                FOREIGN KEY(user_id) REFERENCES users(id)
            );
        """;

        try (
                Connection conn = DatabaseManager.connect();
                Statement stmt = conn.createStatement()
        ) {

            stmt.execute(usersTable);
            stmt.execute(booksTable);

            System.out.println("Database inizializzato");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createAdminIfNotExists() {
        UserDAO dao = new UserDAO();
        if (dao.findByUsername("admin") != null) {
            return;
        }

        User admin = new User();
        admin.setUsername("admin");
        admin.setPasswordHash(PasswordUtil.hash("admin"));
        admin.setEmail("admin@local");
        admin.setCreatedAt(LocalDateTime.now().toString());
        dao.insert(admin);

        System.out.println("admin creato");
    }
}