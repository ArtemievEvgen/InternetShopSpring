package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Account;
import springShop.entity.Order;
import springShop.entity.Producer;
import springShop.entity.Product;
import springShop.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping
    public List<Product> getAll() {
        return productServiceImpl.findAll();
    }

    @GetMapping("/id/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
        return new ResponseEntity<>(productServiceImpl.findById(productId), HttpStatus.OK);
    }

    @GetMapping("/min/{price}")
    public List<Product> minPrice(@PathVariable("price") Double price) {
        return productServiceImpl.minPriceList(price);
    }

    @GetMapping("/max/{price}")
    public List<Product> maxPrice(@PathVariable("price") Double price) {
        return productServiceImpl.maxPriceList(price);
    }

    @GetMapping("/eq/{price}")
    public List<Product> eqPrice(@PathVariable("price") Double price) {
        return productServiceImpl.eqPriceList(price);
    }

    @GetMapping("/category/{category}")
    public List<Product> categoryList(@PathVariable("category") String category) {
        return productServiceImpl.categoryList(category);
    }

    @GetMapping("/producer/{producer}")
    public List<Product> producerList(@PathVariable("producer") Producer producer) {
        return productServiceImpl.producerList(producer);
    }
//    @GetMapping("/category/{productCategory}")
//    public ResponseEntity<Product> getProductByCategory(@PathVariable String productCategory){return new ResponseEntity<>(productServiceImpl.findByCategory(),HttpStatus.OK);}
//
//    @GetMapping("/producer/{productProducer}")
//    public ResponseEntity<Product> getProductByProducer(@PathVariable String productProducer){return new ResponseEntity<>(productServiceImpl.findByProducer(productProducer),HttpStatus.OK);}

}
