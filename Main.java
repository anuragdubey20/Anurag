package year;
import java.util.ArrayList;
import java.util.Iterator;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void createProduct(int id, String name, double price) {
        Product product = new Product(id, name, price);
        products.add(product);
    }

    public void updateProduct(int id, double newPrice) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setPrice(newPrice);
                break;
            }
        }
    }

    public void deleteProduct(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("----------------------");
        }
    }
}

public class Main {

	public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Create products
        manager.createProduct(1, "Product A", 9.99);
        manager.createProduct(2, "Product B", 19.99);
        manager.createProduct(3, "Product C", 29.99);

        // Display all products
        System.out.println("All products:");
        manager.displayProducts();

        // Update product with ID 2
        manager.updateProduct(2, 24.99);

        // Delete product with ID 1
        manager.deleteProduct(1);

        // Display updated product list
        System.out.println("Updated products:");
        manager.displayProducts();
    }

}
