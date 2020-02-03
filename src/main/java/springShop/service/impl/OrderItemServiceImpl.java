package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.OrderItemRepository;
import springShop.entity.OrderItem;

import java.util.List;

@Service
public class OrderItemServiceImpl {
    @Autowired
    private OrderItemRepository orderItemRepository;

}
