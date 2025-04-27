import java.util.*;
import java.util.stream.Collectors;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public double getTotalRevenue() { // Added getter method
        return totalRevenue;
    }

    @Override
    public String toString() {
        return productId + " - Total Revenue: $" + totalRevenue;
    }
}

public class SalesProcessor {
    public static List<ProductSales> analyzeSales(List<Sale> sales) {
        return sales.stream()
            .filter(s -> s.quantity > 10) // Filtering sales with quantity > 10
            .map(s -> new ProductSales(s.productId, s.quantity * s.price)) // Transforming into ProductSales objects
            .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed()) // Sorting by revenue
            .limit(5) // Limiting to top 5 products
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Sale> sales = List.of(
            new Sale("P1", 15, 100),
            new Sale("P2", 8, 200),
            new Sale("P3", 20, 150),
            new Sale("P4", 30, 80),
            new Sale("P5", 12, 300),
            new Sale("P6", 25, 50)
        );

        List<ProductSales> topProducts = analyzeSales(sales);
        topProducts.forEach(System.out::println); // Printing top 5 products
    }
}