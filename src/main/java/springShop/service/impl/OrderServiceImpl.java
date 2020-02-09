package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.OrderRepository;
import springShop.entity.Order;
import springShop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order update(Order newOrder, Integer id) {
        return null;
    }

    @Override
    public Object findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Object findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }
}
