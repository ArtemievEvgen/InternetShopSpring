package springShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springShop.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer>, JpaRepository<Category,Integer> {
}
