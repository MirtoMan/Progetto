package it.unical.kindled.model;

public class User {
    private int id;
    private String username;
    private String passwordHash;
    private String email;
    private String createdAt;

    public User(int id, String us, String ph, String email, String createdAt) {
        this.id = id;
        this.username = us;
        this.passwordHash = ph;
        this.email = email;
        this.createdAt = createdAt;
    }

    public User() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}


