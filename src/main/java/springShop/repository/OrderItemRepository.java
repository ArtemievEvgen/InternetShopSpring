package springShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springShop.entity.OrderItem;

@Repository
public interface OrderItemRepository extends  JpaRepository<OrderItem, Integer> {

//      void getTopByOrderByIdDesc(Integer id);

}
