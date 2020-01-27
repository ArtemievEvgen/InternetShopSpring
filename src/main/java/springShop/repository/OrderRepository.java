package springShop.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springShop.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>, JpaRepository<Order, Integer> {
//
//    Order findById(Long id);
//
//    List<Order> findByIdAccount(Integer idAccount, Pageable pageble);
//
//    int countByIdAccount(Integer idAccount);
}

