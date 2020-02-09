package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Category;
import springShop.entity.Producer;
import springShop.repository.ProducerRepository;
import springShop.repository.ProductRepository;
import springShop.service.ProducerService;
import springShop.service.impl.ProducerServiceImpl;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @GetMapping
    public List<Producer> getAll() {
        return producerService.findAll();
    }

    @PostMapping
    public Producer newProducer(@RequestBody Producer newProducer) {
        return producerService.save(newProducer); }

    @DeleteMapping("/{producerId}")
    void deleteProducer(@PathVariable Integer id) {
        producerService.deleteById(id);
    }
}
