import java.util.Scanner;

public class LibraryCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View All Users");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bId, title, author));
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String uName = sc.nextLine();
                    library.addUser(new User(uId, uName));
                    break;
                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    int ibId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int iuId = sc.nextInt();
                    library.issueBook(ibId, iuId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    int rbId = sc.nextInt();
                    library.returnBook(rbId);
                    break;
                case 5:
                    library.listBooks();
                    break;
                case 6:
                    library.listUsers();
                    break;
                case 7:
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }
}
