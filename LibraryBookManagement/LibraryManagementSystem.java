import java.util.List;
import java.util.Scanner;

/**
 * LibraryManagementSystem.java
 * ─────────────────────────────────────────────────────────────────────────────
 * Main entry point for the Library Book Management System.
 *
 * Concepts demonstrated:
 *  • ArrayList with dynamic resizing
 *  • Add / Remove / Search / Display / Issue / Return operations
 *  • Menu-driven console application with Scanner input
 *  • Separation of concerns (Book model ← Library service ← Main UI)
 * ─────────────────────────────────────────────────────────────────────────────
 */
public class LibraryManagementSystem {

    private static final Scanner sc = new Scanner(System.in);
    private static final Library library = new Library();

    // ─────────────────────────────────────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        preloadSampleBooks(); // Pre-populate with sample data

        System.out.println("\n  ╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║      📚  LIBRARY BOOK MANAGEMENT SYSTEM  📚          ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("  Enter your choice: ");

            switch (choice) {

                // ── 1. Add a new book ─────────────────────────────────────────
                case 1 -> {
                    System.out.println("\n  ── ADD NEW BOOK ─────────────────────────────────────");
                    System.out.print("  Enter title  : ");
                    String title = sc.nextLine().trim();
                    System.out.print("  Enter author : ");
                    String author = sc.nextLine().trim();
                    System.out.print("  Enter genre  : ");
                    String genre = sc.nextLine().trim();

                    if (title.isEmpty() || author.isEmpty()) {
                        System.out.println("  ✘ Title and Author cannot be empty.");
                    } else {
                        library.addBook(title, author, genre);
                    }
                }

                // ── 2. Remove a book ──────────────────────────────────────────
                case 2 -> {
                    System.out.println("\n  ── REMOVE BOOK ──────────────────────────────────────");
                    int id = readInt("  Enter Book ID to remove: ");
                    library.removeBook(id);
                }

                // ── 3. Search by title ────────────────────────────────────────
                case 3 -> {
                    System.out.println("\n  ── SEARCH BY TITLE ──────────────────────────────────");
                    System.out.print("  Enter title keyword: ");
                    String keyword = sc.nextLine().trim();
                    List<Book> found = library.searchByTitle(keyword);

                    if (found.isEmpty()) {
                        System.out.println("  ✘ No books found with title containing \"" + keyword + "\".");
                    } else {
                        System.out.println("  ✔ Found " + found.size() + " book(s):");
                        found.forEach(System.out::println);
                    }
                }

                // ── 4. Search by author ───────────────────────────────────────
                case 4 -> {
                    System.out.println("\n  ── SEARCH BY AUTHOR ─────────────────────────────────");
                    System.out.print("  Enter author name: ");
                    String author = sc.nextLine().trim();
                    List<Book> found = library.searchByAuthor(author);

                    if (found.isEmpty()) {
                        System.out.println("  ✘ No books found by author \"" + author + "\".");
                    } else {
                        System.out.println("  ✔ Found " + found.size() + " book(s):");
                        found.forEach(System.out::println);
                    }
                }

                // ── 5. Display all books ──────────────────────────────────────
                case 5 -> library.displayAllBooks();

                // ── 6. Display available books only ──────────────────────────
                case 6 -> library.displayAvailableBooks();

                // ── 7. Issue a book ───────────────────────────────────────────
                case 7 -> {
                    System.out.println("\n  ── ISSUE BOOK ───────────────────────────────────────");
                    int id = readInt("  Enter Book ID to issue: ");
                    library.issueBook(id);
                }

                // ── 8. Return a book ──────────────────────────────────────────
                case 8 -> {
                    System.out.println("\n  ── RETURN BOOK ──────────────────────────────────────");
                    int id = readInt("  Enter Book ID to return: ");
                    library.returnBook(id);
                }

                // ── 9. Library Statistics ─────────────────────────────────────
                case 9 -> library.displayStats();

                // ── 0. Exit ───────────────────────────────────────────────────
                case 0 -> {
                    System.out.println("\n  👋 Thank you for using the Library Management System. Goodbye!");
                    running = false;
                }

                default -> System.out.println("\n  ✘ Invalid choice. Please enter a number from the menu.");
            }

            System.out.println(); // spacing
        }

        sc.close();
    }

    // ─────────────────────────────────────────────────────────────────────────
    // HELPER – Print the main menu
    // ─────────────────────────────────────────────────────────────────────────
    private static void printMenu() {
        System.out.println("  ┌────────────────────────────────────────┐");
        System.out.println("  │              MAIN MENU                 │");
        System.out.println("  ├────────────────────────────────────────┤");
        System.out.println("  │  1. Add a New Book                     │");
        System.out.println("  │  2. Remove a Book (by ID)              │");
        System.out.println("  │  3. Search Book by Title               │");
        System.out.println("  │  4. Search Book by Author              │");
        System.out.println("  │  5. Display All Books                  │");
        System.out.println("  │  6. Display Available Books Only       │");
        System.out.println("  │  7. Issue a Book                       │");
        System.out.println("  │  8. Return a Book                      │");
        System.out.println("  │  9. Library Statistics                 │");
        System.out.println("  │  0. Exit                               │");
        System.out.println("  └────────────────────────────────────────┘");
    }

    // ─────────────────────────────────────────────────────────────────────────
    // HELPER – Read an integer safely (handles bad input)
    // ─────────────────────────────────────────────────────────────────────────
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  ✘ Please enter a valid integer.");
            }
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // HELPER – Pre-load the ArrayList with sample books
    // Demonstrates that ArrayList starts small and grows automatically
    // ─────────────────────────────────────────────────────────────────────────
    private static void preloadSampleBooks() {
        System.out.println("\n  Loading sample books into the library...");

        library.addBook("The Alchemist",                      "Paulo Coelho",        "Fiction");
        library.addBook("Clean Code",                         "Robert C. Martin",    "Programming");
        library.addBook("To Kill a Mockingbird",              "Harper Lee",          "Classic");
        library.addBook("Introduction to Algorithms",         "Cormen et al.",       "Computer Science");
        library.addBook("Sapiens: A Brief History",           "Yuval Noah Harari",   "Non-Fiction");
        library.addBook("Design Patterns",                    "Gang of Four",        "Programming");
        library.addBook("1984",                               "George Orwell",       "Dystopian");
        library.addBook("The Great Gatsby",                   "F. Scott Fitzgerald", "Classic");
        library.addBook("Effective Java",                     "Joshua Bloch",        "Programming");
        library.addBook("Atomic Habits",                      "James Clear",         "Self-Help");

        System.out.println("\n  ✔ 10 sample books loaded. ArrayList current size = 10");
        System.out.println("  (ArrayList dynamically resized its internal array as books were added)\n");
    }
}
