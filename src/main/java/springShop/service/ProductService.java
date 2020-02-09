package springShop.service;


import org.springframework.data.jpa.domain.Specification;
import springShop.entity.Account;
import springShop.entity.Product;

import java.util.List;

public interface ProductService {

    Product update(Product newProduct, Integer id);

    List<Product> findAll(Specification<Product> specification);

    Object findById(Integer id);

    Product save(Product newProduct);

    void deleteById(Integer id);
}
