package springShop.service;


import springShop.entity.Category;
import springShop.entity.Producer;
import springShop.entity.Product;

import java.util.List;

public interface ProducerService {
    Producer update(Producer newProducer, Integer id);

    List<Producer> findAll();

    Producer save(Producer newProducer);

    void deleteById(Integer id);
}
