package in.srmuniversity.productmanagement.controller;

import in.srmuniversity.productmanagement.entity.Product;
import in.srmuniversity.productmanagement.helper.FileUploadHelper;
import in.srmuniversity.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private FileUploadHelper fileUploadHelper;

    // Get API
    // All Products
    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // Get API
    // Single Product Using the Product ID
    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProduct(id);
    }

    // Post API
    // Adding the Product and Image using the multipart file.
    @RequestMapping(method = RequestMethod.POST, value = "product/add")
    public void addProduct(@RequestParam("image") MultipartFile file, @RequestParam("id") int id,
            @RequestParam("name") String name, @RequestParam("price") double price,
            @RequestParam("description") String description,
            @RequestParam("quantity") int quantity) {

        // Initializing the image url variable
        String imageUrl = "";

        try {

            // validation
            if (file.isEmpty()) {
                System.out.println("Request Must Contain a File");
            }

            // Content Filtering
            if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/jpg")
                    && !file.getContentType().equals("image/png")) {
                System.out.println("Only JPEG, JPG or PNG file format is Allowed");
            }

            // Uploadation Process

            boolean _isFileExists = fileUploadHelper.uploadFile(file);

            if (_isFileExists) {
                imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
                        .path(file.getOriginalFilename() + ".png").toUriString();

            }

            // Creating a object of Product
            Product product = new Product(id, name, price, description, imageUrl, quantity);
            // Passing the final product object to save into the database [IBM's DB2]
            service.addProduct(product);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Something Went Wrong with error: " + e.toString());
        }
    }
}
