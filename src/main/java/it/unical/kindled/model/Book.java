package it.unical.kindled.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String filePath;
    private String coverPath;
    private String addedAt;
    private int userId;

    public Book(int id , String title, String author, String filePath, String coverPath, String addedAt, int user) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.filePath = filePath;
        this.coverPath = coverPath;
        this.addedAt = addedAt;
        this.userId = user;
    }
    public Book () {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
