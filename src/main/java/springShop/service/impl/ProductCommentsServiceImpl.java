package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.ProductCommentRepository;
import springShop.entity.ProductComment;

import java.util.List;

@Service
public class ProductCommentsServiceImpl {
    @Autowired
    private ProductCommentRepository productCommentRepository;

}
