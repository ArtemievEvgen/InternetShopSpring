package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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

    @Override
    public Product update(Product newProduct, Integer id) {
        return null;
    }

    @Override
    public List<Product> findAll(Specification<Product> specification) {
        return productRepository.findAll(specification);
    }

    @Override
    public Object findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product newProduct) {
        return productRepository.save(newProduct);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
