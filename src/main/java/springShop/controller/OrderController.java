package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springShop.entity.Order;
import springShop.service.impl.OrderServiceImpl;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("/order")
    public List<Order> getAll() {
        return orderServiceImpl.findAll();
    }
}
