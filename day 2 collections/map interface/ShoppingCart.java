
import java.util.*;

public class ShoppingCart {
    Map<String, Double> priceMap = new HashMap<>();
    Map<String, Integer> cart = new LinkedHashMap<>();
    TreeMap<Double, String> sortedItems = new TreeMap<>();

    void addProduct(String name, double price) {
        priceMap.put(name, price);
    }

    void addToCart(String name, int quantity) {
        if (priceMap.containsKey(name)) {
            cart.put(name, cart.getOrDefault(name, 0) + quantity);
            sortedItems.put(priceMap.get(name), name);
        }
    }

    void displayCart() {
        cart.forEach((name, quantity) -> System.out.println(name + " x" + quantity + " - $" + priceMap.get(name)));
    }

    void displaySortedItems() {
        sortedItems.forEach((price, name) -> System.out.println(name + " - $" + price));
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1200);
        cart.addProduct("Phone", 800);
        cart.addProduct("Headphones", 200);

        cart.addToCart("Laptop", 1);
        cart.addToCart("Phone", 2);
        cart.addToCart("Headphones", 3);

        System.out.println("\nCart Contents:");
        cart.displayCart();

        System.out.println("\nProducts Sorted by Price:");
        cart.displaySortedItems();
    }
}

