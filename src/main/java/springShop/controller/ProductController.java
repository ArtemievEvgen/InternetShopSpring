package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springShop.entity.*;
import springShop.repository.ProducerRepository;
import springShop.repository.ProductRepository;
import springShop.service.ProductService;
import springShop.service.impl.ProductServiceImpl;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @DeleteMapping("/{productId}")
    void deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/min")
    public List<Product> minPrice(@RequestParam("price") Double price) {
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
//
//    @GetMapping("/category/{category}")
//    public List<Product> categoryList(@PathVariable("category") String category) {
//        return productServiceImpl.categoryList(category);
//    }

    //    @GetMapping("/producer/{producer}")
//    public List<Product> producerList(@PathVariable("producer") Producer producer) {
//        return productServiceImpl.producerList(producer);
//    }
    @GetMapping("/category/{productCategory}")
    public ResponseEntity<?> getProductByCategory(@PathVariable String productCategory) {
        return new ResponseEntity<>(productRepository.categoryList(productCategory), HttpStatus.OK);
    }

    @GetMapping("/producer/{productProducer}")
    public ResponseEntity<?> getProductByProducer(@PathVariable String productProducer) {
        return new ResponseEntity<>(productRepository.producerList(productProducer), HttpStatus.OK);
    }

//    @GetMapping("/producer/{productProducer}")
//    public ResponseEntity<Product> getProductByProducer(@PathVariable String productProducer){return new ResponseEntity<>(productServiceImpl.findByProducer(productProducer),HttpStatus.OK);}

}
