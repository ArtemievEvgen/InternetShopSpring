package springShop.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springShop.entity.Producer;
import springShop.entity.Product;

import javax.persistence.criteria.ListJoin;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {



//    @Query("SELECT u FROM Product u WHERE u.price = :paramPrice1 AND :parammPrice2 >= u.price")
//    List<Product> intervalPriceList(@Param("paramPrice") Double price);
//
      // @Query("SELECT u FROM Product u WHERE u.category = :paramCategory")
    // @Query("SELECT u FROM Product u JOIN Category c ON u.category = c WHERE c = :paramCategory")

//       @Query("SELECT u FROM Product u WHERE u.producer = :paramProducer")
//    List<Product> producerList(@Param("paramProducer") Producer producer);

//       Product findByCategory(String category);
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

    @Query("SELECT u FROM Product u WHERE u.producer = (SELECT p FROM Producer p WHERE p.name = :producer)")
    ListJoin<Product, Producer> producerList(@Param("producer") String producer);

//    List<Product> findAll();
}
