package springShop.service;

import io.vavr.control.Either;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import springShop.dto.ProductDTO;
import springShop.dto.ProductListRequest;
import springShop.entity.Product;
import springShop.service.impl.error.ErrorResponse;

import java.util.List;

public interface ProductService {

    Product update(Product newProduct, Integer id);


    Object findById(Integer id);

    Product save(Product newProduct);

    void deleteById(Integer id);


    List<Product> findAll(Specification<Product> specification);
}
