package in.srmuniversity.productmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Product {

    public Product() {
    }

    @javax.persistence.Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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
