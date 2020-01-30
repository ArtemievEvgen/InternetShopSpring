package springShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springShop.entity.Producer;

@Repository
public interface ProducerRepository extends  JpaRepository<Producer, Integer> {
//    List<Producer> findAll(Sort sort);

}
