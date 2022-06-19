package in.srmuniversity.productmanagement.repository;

import in.srmuniversity.productmanagement.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
