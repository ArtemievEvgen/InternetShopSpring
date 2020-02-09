package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Producer;
import springShop.entity.ProductComment;
import springShop.repository.ProductCommentRepository;
import springShop.service.ProductCommentService;
import springShop.service.impl.ProductCommentsServiceImpl;


import javax.annotation.security.RolesAllowed;
import java.util.List;
@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/productComments")
public class ProductCommentController {
    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping
    public List<ProductComment> getAll() {
        return productCommentService.findAll();
    }

    @PostMapping
    public ProductComment newProductComment(@RequestBody ProductComment newProductComment) {
        return  productCommentService.save(newProductComment);
    }

    @DeleteMapping("/{id}")
    void deleteProductComment(@PathVariable Integer id) {
        productCommentService.deleteById(id);
    }
}
