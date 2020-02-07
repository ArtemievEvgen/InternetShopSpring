package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.entity.Product;
import springShop.repository.ProductRepository;
import springShop.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product update(Product newProduct, Integer id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product newProduct) {
        return  productRepository.save(newProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

}
