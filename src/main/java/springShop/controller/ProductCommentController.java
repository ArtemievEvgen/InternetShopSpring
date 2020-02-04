package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Producer;
import springShop.entity.ProductComment;
import springShop.repository.ProductCommentRepository;
import springShop.service.impl.ProductCommentsServiceImpl;


import javax.annotation.security.RolesAllowed;
import java.util.List;
@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/productComments")
public class ProductCommentController {
    @Autowired
    private ProductCommentRepository productCommentRepository;

    @GetMapping
    public List<ProductComment> getAll() {
        return productCommentRepository.findAll();
    }

    @PostMapping
    public ProductComment newProductComment(@RequestBody ProductComment newProductComment) {
        return  productCommentRepository.save(newProductComment);
    }

    @DeleteMapping("/{id}")
    void deleteProductComment(@PathVariable Integer id) {
        productCommentRepository.deleteById(id);
    }
}
