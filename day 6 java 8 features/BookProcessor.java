import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title, author, genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public double getRating() { // Added getter method
        return rating;
    }

    @Override
    public String toString() {
        return title + " by " + author + " - Genre: " + genre + " - Rating: " + rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public double getRating() { // Added getter method for sorting
        return rating;
    }

    @Override
    public String toString() {
        return title + " - Rating: " + rating;
    }
}

public class BookProcessor {
    public static List<BookRecommendation> recommendBooks(List<Book> books) {
        return books.stream()
            .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0) // Filtering books
            .map(b -> new BookRecommendation(b.title, b.rating)) // Transforming into BookRecommendation objects
            .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed()) // Sorting by rating
            .limit(10) // Limiting to top 10 books
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Book> books = List.of(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.2),
            new Book("Neuromancer", "William Gibson", "Science Fiction", 4.3),
            new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.6),
            new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
            new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.4),
            new Book("1984", "George Orwell", "Dystopian", 4.7) // Won't be included (wrong genre)
        );

        List<BookRecommendation> topBooks = recommendBooks(books);
        topBooks.forEach(System.out::println); // Printing recommended books
    }
}