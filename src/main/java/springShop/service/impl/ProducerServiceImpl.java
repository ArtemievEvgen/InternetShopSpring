package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.ProducerRepository;
import springShop.entity.Producer;

import java.util.List;

@Service
public class ProducerServiceImpl {
    @Autowired
    private ProducerRepository producerRepository;

}
