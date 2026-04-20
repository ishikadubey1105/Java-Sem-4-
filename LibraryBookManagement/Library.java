import java.util.ArrayList;
import java.util.List;

/**
 * Library.java
 * Core service class that manages the ArrayList of books.
 * Demonstrates:
 *  - Dynamic resizing via ArrayList
 *  - Add / Remove / Search / Display operations
 *  - Issue and return book workflows
 */
public class Library {

    // ── Central ArrayList – dynamically resizes as books are added/removed ──
    private ArrayList<Book> books;
    private int nextId;

    // Constructor
    public Library() {
        books  = new ArrayList<>();
        nextId = 1;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 1. ADD A BOOK
    // ─────────────────────────────────────────────────────────────────────────
    /**
     * Adds a new book to the library collection.
     * ArrayList automatically resizes its internal array when capacity is exceeded.
     *
     * @param title  Title of the book
     * @param author Author name
     * @param genre  Genre / category
     */
    public void addBook(String title, String author, String genre) {
        Book newBook = new Book(nextId++, title, author, genre);
        books.add(newBook); // O(1) amortised – ArrayList handles resizing internally
        System.out.println("\n  ✔ Book added successfully!");
        System.out.println(newBook);
        System.out.println("  Total books in library: " + books.size());
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 2. REMOVE / DELETE A BOOK BY ID
    // ─────────────────────────────────────────────────────────────────────────
    /**
     * Permanently removes a book record from the library (e.g. lost/damaged).
     * Uses Iterator-safe removal via ArrayList.removeIf().
     *
     * @param bookId The unique ID of the book to remove
     * @return true if the book was found and removed
     */
    public boolean removeBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                Book removed = books.remove(i); // ArrayList shifts elements left – dynamic
                System.out.println("\n  ✔ Book removed: \"" + removed.getTitle() + "\"");
                System.out.println("  Total books in library: " + books.size());
                return true;
            }
        }
        System.out.println("\n  ✘ Book with ID " + bookId + " not found.");
        return false;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 3. SEARCH BOOK BY TITLE (case-insensitive partial match)
    // ─────────────────────────────────────────────────────────────────────────
    /**
     * Searches for books whose title contains the given keyword.
     *
     * @param keyword The search keyword
     * @return List of matching books
     */
    public List<Book> searchByTitle(String keyword) {
        List<Book> results = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Book book : books) { // Enhanced for-loop over ArrayList
            if (book.getTitle().toLowerCase().contains(lowerKeyword)) {
                results.add(book);
            }
        }
        return results;
    }

    /**
     * Searches for books by author name (case-insensitive partial match).
     *
     * @param authorName Author name keyword
     * @return List of matching books
     */
    public List<Book> searchByAuthor(String authorName) {
        List<Book> results = new ArrayList<>();
        String lowerAuthor = authorName.toLowerCase();

        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(lowerAuthor)) {
                results.add(book);
            }
        }
        return results;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 4. DISPLAY ALL BOOKS
    // ─────────────────────────────────────────────────────────────────────────
    /**
     * Displays all books currently in the library ArrayList.
     */
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("\n  The library has no books yet.");
            return;
        }

        System.out.println("\n  ╔══════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("  ║                              ALL BOOKS IN LIBRARY  (" + books.size() + " total)                          ║");
        System.out.println("  ╚══════════════════════════════════════════════════════════════════════════════════════════════╝");

        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    /**
     * Displays only available (not issued) books.
     */
    public void displayAvailableBooks() {
        long count = books.stream().filter(Book::isAvailable).count();

        if (count == 0) {
            System.out.println("\n  No books are currently available (all are issued).");
            return;
        }

        System.out.println("\n  ─── Available Books (" + count + ") ───────────────────────────────────────");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
        System.out.println();
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 5. ISSUE A BOOK (mark as unavailable)
    // ─────────────────────────────────────────────────────────────────────────
    /**
     * Issues a book to a student/member – marks it as unavailable.
     *
     * @param bookId The ID of the book to issue
     * @return true if issued successfully
     */
    public boolean issueBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (!book.isAvailable()) {
                    System.out.println("\n  ✘ \"" + book.getTitle() + "\" is already issued.");
                    return false;
                }
                book.setAvailable(false);
                System.out.println("\n  ✔ Book issued: \"" + book.getTitle() + "\"");
                return true;
            }
        }
        System.out.println("\n  ✘ Book with ID " + bookId + " not found.");
        return false;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 6. RETURN A BOOK (mark as available again)
    // ─────────────────────────────────────────────────────────────────────────
    /**
     * Marks a returned book as available again.
     *
     * @param bookId The ID of the book being returned
     * @return true if returned successfully
     */
    public boolean returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (book.isAvailable()) {
                    System.out.println("\n  ✘ \"" + book.getTitle() + "\" was not issued.");
                    return false;
                }
                book.setAvailable(true);
                System.out.println("\n  ✔ Book returned: \"" + book.getTitle() + "\"");
                return true;
            }
        }
        System.out.println("\n  ✘ Book with ID " + bookId + " not found.");
        return false;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 7. LIBRARY STATISTICS
    // ─────────────────────────────────────────────────────────────────────────
    public void displayStats() {
        long available = books.stream().filter(Book::isAvailable).count();
        long issued    = books.size() - available;

        System.out.println("\n  ┌────────────────────────────┐");
        System.out.println("  │      LIBRARY STATISTICS    │");
        System.out.println("  ├────────────────────────────┤");
        System.out.printf ("  │  Total Books  : %-10d │%n", books.size());
        System.out.printf ("  │  Available    : %-10d │%n", available);
        System.out.printf ("  │  Issued       : %-10d │%n", issued);
        System.out.println("  └────────────────────────────┘");
    }
}
