package in.srmuniversity.productmanagement.service;

import in.srmuniversity.productmanagement.entity.Product;
import in.srmuniversity.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    // Injecting Dependancy
    @Autowired
    private ProductRepository productRepository;

    // private List<Product> products = new ArrayList<>(Arrays.asList(
    // new Product(1, "Cold Coffee", 50, "This is our new addition. Try it and you
    // will fall in love with it.",
    // "", 100),
    // new Product(2, "Mango Shake", 70, "", "", 100),
    // new Product(3, "Chocolate Shake", 80, "", "", 100)));

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add); // lambda Expression
        return productList;
    }

    public Product getProduct(int id) {
        return productRepository.findById(id).get();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
