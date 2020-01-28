package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.entity.Account;
import springShop.repository.OrderRepository;
import springShop.entity.Order;
import springShop.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }
}
