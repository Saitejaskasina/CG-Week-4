class Product<T> {
    T category;
    double price;
    Product(T category, double price) { this.category = category; this.price = price; }
}

class BookCategory {}
class ClothingCategory {}

class Marketplace<T extends Product<?>> {
    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
    }
}

public class OnlineMarketplace2 {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>(new BookCategory(), 500);
        Marketplace.applyDiscount(book, 10);
        System.out.println("Discounted price: " + book.price);
    }
}