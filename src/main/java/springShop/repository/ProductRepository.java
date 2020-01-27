package springShop.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import springShop.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>, JpaRepository<Product, Integer>/*,SearchProductRepository*/ {


    void delete(Product product);

//    List<Product> findByCategoryUrl(String url, Pageable pageable);
//
//    int countByCategoryUrl(String url);
//
//    Product findById(int idProduct);


}
