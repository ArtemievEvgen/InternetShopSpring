package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springShop.entity.Producer;
import springShop.service.impl.ProducerServiceImpl;

import java.util.List;

@RestController
public class ProducerController {
    @Autowired
    private ProducerServiceImpl producerServiceImpl;

    @GetMapping("/producer")
    public List<Producer> getAll() {
        return producerServiceImpl.findAll();
    }
}
