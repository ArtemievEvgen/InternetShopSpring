package springShop.service;


import springShop.entity.Category;
import springShop.entity.Producer;
import springShop.entity.Product;

public interface ProducerService {
    Producer update(Producer newProducer, Integer id);

    Product findByCategory(String name);
    Product findByProducer(String name);
}
