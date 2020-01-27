package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.ProductRepository;
import springShop.entity.Product;
import springShop.service.ProducerService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProducerService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
