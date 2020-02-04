package springShop.service;


import springShop.entity.Category;
import springShop.entity.ProductComment;

public interface ProductCommentService {
    ProductComment update(ProductComment newProductComments, Integer id);

}
