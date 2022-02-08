import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class StockItem {
    private String name;
    private double pricePerUnit;
    private int quantity;

    public StockItem(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + pricePerUnit + ", " + quantity + ";";
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Utils {
    public static List<StockItem> sort(List<StockItem> stockItems) {
        // your code here
        return stockItems.stream()
                .sorted(Comparator.comparing(Utils::totalValue).reversed())
                .collect(Collectors.toList());
    }
    
    private static double totalValue(final StockItem item) {
        return item.getPricePerUnit() * item.getQuantity();
    }
}
