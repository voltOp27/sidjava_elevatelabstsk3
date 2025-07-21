public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    private int issuedToUserId; // Store UserID if issued

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedToUserId = -1;
    }

    // Getters/Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public int getIssuedToUserId() { return issuedToUserId; }

    public void issueTo(int userId) {
        this.isIssued = true;
        this.issuedToUserId = userId;
    }

    public void returnBook() {
        this.isIssued = false;
        this.issuedToUserId = -1;
    }

    @Override
    public String toString() {
        String status = isIssued ? "Issued to User ID: " + issuedToUserId : "Available";
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Status: " + status;
    }
}
