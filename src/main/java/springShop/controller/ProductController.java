package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springShop.entity.*;
import springShop.repository.ProducerRepository;
import springShop.repository.ProductRepository;
import springShop.service.ProductService;
import springShop.service.impl.ProductServiceImpl;
import springShop.specification.AccountSpecification;
import springShop.specification.ProductSpecification;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product>getAll(@RequestParam(required = false) String description,
                               @RequestParam(required = false) String name,
                             /*  @RequestParam(required = false) String price,*/
                               @RequestParam(required = false) String category,
                               @RequestParam(required = false) String producer){
        Specification<Product> specification = Specification
                .where(description == null ? null : ProductSpecification.descriptionContains(description))
                .and(name == null ? null : ProductSpecification.nameContains(name))
             /*   .and(price == null ? null : ProductSpecification.priceContains(price))*/
                .and(category == null ? null : ProductSpecification.categoryContains(category))
                .and(producer == null ? null : ProductSpecification.producerContains(producer));
        return productService.findAll(specification);}

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public Product newProduct(@RequestBody Product newProduct) {
        return productService.save(newProduct);
    }

    @DeleteMapping("/{productId}")
    void deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
    }

}
