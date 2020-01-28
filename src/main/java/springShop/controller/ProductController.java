package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springShop.entity.Product;
import springShop.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping("/product")
    public List<Product> getAll() {
        return productServiceImpl.findAll();
    }

//    @PostMapping("/product") /*id*/
//    public List<Product> getProductById(){return productServiceImpl.findProductById();}
//
//    @PostMapping("/product")
//    public List<Product> getProductByCategory(){return ProductServiceImpl.findProductByCategory();}
//
//    @PostMapping("")
}
