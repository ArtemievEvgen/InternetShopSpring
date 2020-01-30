package springShop.service;


import springShop.entity.Product;

public interface ProducerService {
    Product findByCategory(String name);

    Product findByProducer(String name);
}
