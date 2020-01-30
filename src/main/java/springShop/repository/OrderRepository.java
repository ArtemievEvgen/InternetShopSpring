package springShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springShop.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
//
//    Order findById(Long id);
//
//    List<Order> findByIdAccount(Integer idAccount, Pageable pageble);
//
//    int countByIdAccount(Integer idAccount);
}

