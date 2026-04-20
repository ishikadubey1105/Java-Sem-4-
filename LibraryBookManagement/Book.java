/**
 * Book.java
 * Represents a single book in the library system.
 */
public class Book {

    private int bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    // Constructor
    public Book(int bookId, String title, String author, String genre) {
        this.bookId    = bookId;
        this.title     = title;
        this.author    = author;
        this.genre     = genre;
        this.isAvailable = true; // All newly added books are available by default
    }

    // ── Getters ───────────────────────────────────────────────────────────────
    public int    getBookId()    { return bookId;    }
    public String getTitle()     { return title;     }
    public String getAuthor()    { return author;    }
    public String getGenre()     { return genre;     }
    public boolean isAvailable() { return isAvailable; }

    // ── Setters ───────────────────────────────────────────────────────────────
    public void setAvailable(boolean available) { this.isAvailable = available; }

    /**
     * Returns a formatted string representation of the book details.
     */
    @Override
    public String toString() {
        return String.format(
            "  ID: %-4d | Title: %-35s | Author: %-22s | Genre: %-15s | Status: %s",
            bookId,
            title,
            author,
            genre,
            isAvailable ? "✔ Available" : "✘ Issued"
        );
    }
}
