import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    @Override public String toString() { return name; }
}

class Electronics extends WarehouseItem { Electronics(String name) { super(name); } }
class Groceries extends WarehouseItem { Groceries(String name) { super(name); } }
class Furniture extends WarehouseItem { Furniture(String name) { super(name); } }

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    void addItem(T item) { items.add(item); }
    List<T> getItems() { return items; }
    static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) System.out.println(item);
    }
}

public class SmartWarehouse1 {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        Storage.displayItems(electronicsStorage.getItems());
    }
}