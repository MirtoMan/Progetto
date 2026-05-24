package it.unical.kindled.dao;
import it.unical.kindled.database.DatabaseManager;
import it.unical.kindled.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void insert(Book book) {
        String sql = "INSERT INTO books(title, author, file_path, cover_path, added_at, user_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getFilePath());
            stmt.setString(4, book.getCoverPath());
            stmt.setString(5, book.getAddedAt());
            stmt.setInt(6, book.getUserId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> findByUserId(int userId) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE user_id = ?";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(mapBook(rs));
            }

        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return list;
    }

    public Book findById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";

        try (Connection conn = DatabaseManager.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapBook(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete (int id, int usr_id) {
        String sql = "DELETE FROM books WHERE id = ? AND user_id = ?";
        try (Connection conn = DatabaseManager.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, usr_id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        Book b = new Book();
        b.setId(rs.getInt("id"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setFilePath(rs.getString("file_path"));
        b.setCoverPath(rs.getString("cover_path"));
        b.setAddedAt(rs.getString("added_at"));
        b.setUserId(rs.getInt("user_id"));
        return b;
    }
}
