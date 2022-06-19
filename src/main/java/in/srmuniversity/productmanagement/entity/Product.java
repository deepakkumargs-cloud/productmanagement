package in.srmuniversity.productmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Product {

    // Default Constructor
    public Product() {
    }

    // All the Columns
    @javax.persistence.Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private int quantity;

    // Single/individual Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    // Single/individual Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Grouped Setters
    public Product(int id, String name, double price, String description, String imageUrl, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Product[prodName=%s, prodPrice='%f', prodDiscription=%s,]", name, price,
                description);
    }
}
