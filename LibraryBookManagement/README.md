# 📚 Library Book Management System

A Java console application that manages a collection of books using `ArrayList`,
demonstrating dynamic resizing and easy data handling.

---

## 📁 File Structure

```
LibraryBookManagement/
├── Book.java                    ← Model class (entity)
├── Library.java                 ← Service class (ArrayList operations)
└── LibraryManagementSystem.java ← Main class (menu-driven UI)
```

---

## ▶️ How to Compile & Run

### Option A — Using an IDE (Recommended)
1. Open **Eclipse** / **IntelliJ IDEA** / **VS Code with Java Extension**
2. Create a new Java project and add the three `.java` files
3. Run `LibraryManagementSystem.java`

### Option B — Using Command Line (requires JDK)
```bash
cd LibraryBookManagement
javac Book.java Library.java LibraryManagementSystem.java
java LibraryManagementSystem
```

---

## 🧩 Features

| #  | Feature                        | Description                                           |
|----|--------------------------------|-------------------------------------------------------|
| 1  | **Add a New Book**             | Adds book to ArrayList; auto-resizes if needed        |
| 2  | **Remove a Book**              | Removes by ID; ArrayList shifts elements dynamically  |
| 3  | **Search by Title**            | Case-insensitive partial match across all books       |
| 4  | **Search by Author**           | Case-insensitive partial match by author name         |
| 5  | **Display All Books**          | Lists all books with ID, title, author, genre, status |
| 6  | **Display Available Books**    | Filters and shows only books not yet issued           |
| 7  | **Issue a Book**               | Marks a book as "Issued" (unavailable)                |
| 8  | **Return a Book**              | Marks a book as "Available" again                     |
| 9  | **Library Statistics**         | Shows total, available, and issued counts             |

---

## 💡 Key Concepts — ArrayList

```java
ArrayList<Book> books = new ArrayList<>();

books.add(newBook);          // O(1) amortized — resizes internally when full
books.remove(index);         // O(n)  — shifts remaining elements left
books.get(index);            // O(1)  — direct index access
books.size();                // O(1)  — tracks count dynamically
```

### Why ArrayList over Array?
| Feature              | Array (`Book[]`)      | ArrayList (`ArrayList<Book>`) |
|----------------------|-----------------------|-------------------------------|
| Size                 | Fixed at creation     | **Dynamic — grows/shrinks**   |
| Add element          | Manual resizing       | `list.add()` — automatic      |
| Remove element       | Manual shift          | `list.remove()` — automatic   |
| Search               | Manual loop           | `list.contains()` / loop      |
| Utility methods      | None                  | `size()`, `isEmpty()`, etc.   |

---

## 🏗️ Class Design

```
LibraryManagementSystem (Main)
        │  uses
        ▼
     Library  ── ArrayList<Book> ──▶  Book
   (service)         (data)          (model)
```
