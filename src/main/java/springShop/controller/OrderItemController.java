package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springShop.entity.OrderItem;
import springShop.repository.OrderItemRepository;
import springShop.service.OrderItemService;
import springShop.service.impl.OrderItemServiceImpl;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/orderItem")
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }
}
