import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    // Add new book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Add new user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully.");
    }

    // Issue book to user
    public boolean issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (user == null) {
            System.out.println("User not found.");
            return false;
        }
        if (book.isIssued()) {
            System.out.println("Book is already issued to another user.");
            return false;
        }
        book.issueTo(userId);
        System.out.println("Book issued successfully to user: " + user.getName());
        return true;
    }

    // Return a book
    public boolean returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }
        if (!book.isIssued()) {
            System.out.println("Book is not currently issued.");
            return false;
        }
        book.returnBook();
        System.out.println("Book returned successfully.");
        return true;
    }

    // List All Books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // List All Users
    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in library.");
            return;
        }
        for (User u : users) {
            System.out.println(u);
        }
    }

    // Helpers
    public Book findBookById(int bookId) {
        for (Book b : books)
            if (b.getId() == bookId) return b;
        return null;
    }

    public User findUserById(int userId) {
        for (User u : users)
            if (u.getUserId() == userId) return u;
        return null;
    }
}
