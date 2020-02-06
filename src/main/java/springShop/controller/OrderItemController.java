package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springShop.entity.OrderItem;
import springShop.repository.OrderItemRepository;
import springShop.service.OrderItemService;
import springShop.service.impl.OrderItemServiceImpl;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

}
