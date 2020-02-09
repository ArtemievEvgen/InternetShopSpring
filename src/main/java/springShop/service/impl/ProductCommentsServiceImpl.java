package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.ProductCommentRepository;
import springShop.entity.ProductComment;
import springShop.service.ProductCommentService;

import java.util.List;

@Service
public class ProductCommentsServiceImpl implements ProductCommentService {
    @Autowired
    private ProductCommentRepository productCommentRepository;

    @Override
    public ProductComment update(ProductComment newProductComments, Integer id) {
        return null;
    }

    @Override
    public List<ProductComment> findAll() {
        return productCommentRepository.findAll();
    }

    @Override
    public ProductComment save(ProductComment newProductComment) {
        return productCommentRepository.save(newProductComment);
    }

    @Override
    public void deleteById(Integer id) {
        productCommentRepository.deleteById(id);
    }
}
