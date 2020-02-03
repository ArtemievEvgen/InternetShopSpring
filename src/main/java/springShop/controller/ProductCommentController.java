package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springShop.entity.ProductComment;
import springShop.repository.ProductCommentRepository;
import springShop.service.impl.ProductCommentsServiceImpl;


import java.util.List;

@RestController
public class ProductCommentController {
    @Autowired
    private ProductCommentRepository productCommentRepository;

    @GetMapping("/productComments")
    public List<ProductComment> getAll() {
        return productCommentRepository.findAll();
    }
}
