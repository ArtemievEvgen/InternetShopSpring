package springShop.service;


import springShop.entity.Category;
import springShop.entity.ProductComment;

import java.util.List;

public interface ProductCommentService {
    ProductComment update(ProductComment newProductComments, Integer id);

    List<ProductComment> findAll();

    ProductComment save(ProductComment newProductComment);

    void deleteById(Integer id);
}
