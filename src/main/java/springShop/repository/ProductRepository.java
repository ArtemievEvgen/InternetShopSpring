package springShop.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springShop.entity.Account;
import springShop.entity.Category;
import springShop.entity.Producer;
import springShop.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    void delete(Product product);


    @Query("SELECT u FROM Product u WHERE u.price >= :paramPrice")
    List<Product> minPriceList(@Param("paramPrice") Double price);

    @Query("SELECT u FROM Product u WHERE u.price <= :paramPrice")
    List<Product> maxPriceList(@Param("paramPrice") Double price);

    @Query("SELECT u FROM Product u WHERE u.price = :paramPrice")
    List<Product> eqPriceList(@Param("paramPrice") Double price);

//    @Query("SELECT u FROM Product u WHERE u.price = :paramPrice1 AND :parammPrice2 >= u.price")
//    List<Product> intervalPriceList(@Param("paramPrice") Double price);

    @Query("SELECT u FROM Product u WHERE u.price = :paramCategory")
    List<Product> categoryList(@Param("paramCategory") String category);

    @Query("SELECT u FROM Product u WHERE u.producer = :paramProducer")
    List<Product> producerList(@Param("paramProducer") Producer producer);


//    Product findByPrice(Double price);
//    List<Product> findByCategoryUrl(String url, Pageable pageable);
//
//    int countByCategoryUrl(String url);
//
//    Product findById(int idProduct);

//    Product findByCategory(Category category);
//
//    Product findByProducer(Producer producer);

//    Product findByImageLink(String imageLink);

    //    List<Product> findAllByPrice (List <Double> price);

}
