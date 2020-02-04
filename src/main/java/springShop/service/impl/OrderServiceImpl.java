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

    @Override
    public Order update(Order newOrder, Integer id) {
        return null;
    }
}
