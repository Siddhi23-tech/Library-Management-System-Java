import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        books.add(new Book(id, title));
        System.out.println("Book added successfully!\n");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.\n");
            return;
        }

        System.out.println("\nLibrary Books:");
        for (Book b : books) {
            System.out.println("ID: " + b.id + 
                               ", Title: " + b.title + 
                               ", Status: " + (b.isIssued ? "Issued" : "Available"));
        }
        System.out.println();
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued successfully!\n");
                return;
            }
        }
        System.out.println("Book not found or already issued.\n");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned successfully!\n");
                return;
            }
        }
        System.out.println("Invalid book ID or book not issued.\n");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("----- Library Management System -----");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.\n");
            }
        }
    }
}
