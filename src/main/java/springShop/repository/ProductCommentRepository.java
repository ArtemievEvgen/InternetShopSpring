package springShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springShop.entity.ProductComment;

@Repository
public interface ProductCommentRepository extends  JpaRepository<ProductComment, Integer> {
}
