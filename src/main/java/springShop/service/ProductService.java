package springShop.service;


import org.springframework.web.bind.annotation.PathVariable;
import springShop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product update(Product newProduct, Integer id);

    List<Product> findAll();

    Optional<Product> findProductById(Integer id);

    Product saveProduct( Product newProduct);

    void deleteProduct(@PathVariable Integer id);
}
