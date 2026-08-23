import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return productName + " x" + quantity + " = " + (price * quantity);
    }
}

class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }

        return total;
    }

    @Override
    public String toString() {
        String result = "Order ID: " + orderId + "\n";
        result += "Products:\n";

        for (Product product : products) {
            result += product + "\n";
        }

        result += "Total: " + calculateTotal();

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String orderId = sc.nextLine().trim();
        int n = Integer.parseInt(sc.nextLine().trim());

        Order order = new Order(orderId);

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(",");

            String productName = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());
            int quantity = Integer.parseInt(parts[2].trim());

            Product product = new Product(productName, price, quantity);
            order.addProduct(product);
        }

        System.out.println(order);

        sc.close();
    }
}