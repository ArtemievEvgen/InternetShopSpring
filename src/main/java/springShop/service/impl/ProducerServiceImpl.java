package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.ProducerRepository;
import springShop.entity.Producer;
import springShop.service.ProducerService;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public Producer update(Producer newProducer, Integer id) {
        return null;
    }

    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public Producer save(Producer newProducer) {
        return producerRepository.save(newProducer);
    }

    @Override
    public void deleteById(Integer id) {
        producerRepository.deleteById(id);

    }
}
