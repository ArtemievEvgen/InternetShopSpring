package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.entity.Account;
import springShop.entity.Category;
import springShop.entity.Producer;
import springShop.entity.Product;
import springShop.repository.CategoryRepository;
import springShop.repository.ProducerRepository;
import springShop.repository.ProductRepository;
import springShop.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProducerRepository producerRepository;


    public List<Product> minPriceList(Double price) {
        return productRepository.minPriceList(price);
    }
    public List<Product> maxPriceList(Double price) {
        return productRepository.maxPriceList(price);
    }
    public List<Product> eqPriceList(Double price) {
        return productRepository.eqPriceList(price);
    }

    @Override
    public Product update(Product newProduct, Integer id) {
        return null;
    }

//    public List<?> categoryList(String productCategory){return productRepository.categoryList(productCategory);}
//    public List<Product> producerList(Producer producer){return productRepository.producerList(producer);}

//
//    public Product findByPrice(Double price){return productRepository.findByPrice(price);}
//
//    public Product findByImageLink(String imageLink) {
//        return productRepository.findByImageLink(imageLink);
//    }
//
//    public Product findByCategory(Category category) {
//        return productRepository.findByCategory(category);
//    }
//
//
//    public Product findByProducer(Producer producer) {
//        return productRepository.findByProducer(producer);
//    }

//
//    public boolean deleteAccount(Integer productId) {
//        if (productRepository.findById(productId).isPresent()) {
//            productRepository.deleteById(productId);
//            return true;
//        }
//        return false;
//    }
}
