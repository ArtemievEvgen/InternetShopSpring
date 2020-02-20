package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import springShop.entity.Order;
import springShop.entity.OrderItem;
import springShop.entity.Product;
import springShop.entity.Status;
import springShop.repository.AccountRepository;
import springShop.repository.OrderItemRepository;
import springShop.repository.OrderRepository;
import springShop.service.OrderService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

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

//    @Override
//    public void save(ArrayList<Order> order) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Order order1 = new Order();
//        order1.setIdAccount(accountRepository.findByUsername(user.getUsername()));
//        order1.setCreated(new Timestamp(System.currentTimeMillis()));
//        order1.setStatuses(Collections.singleton(new Status(1, "Order processing")));
//        orderRepository.save(order1);
//
//
//        for (Order order2 : order) {
//            order2.getId();
//            order2.setIdOrder(orderItemRepository.getTopByOrderByIdDesc());
//            order2.getIdProduct();
//            order2.getCount();
//        orderItemRepository.save(order1);
//        }
//    }


    @Override
    public Optional<Order> update(Order updateOrder, Integer id) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatuses(updateOrder.getStatuses());
                    return orderRepository.save(order);
                });
    }

    @Override
    public void save(ArrayList<OrderItem> orderItems) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order = new Order();
        order.setIdAccount(accountRepository.findByUsername(user.getUsername()));
        order.setCreated(new Timestamp(System.currentTimeMillis()));
        order.setStatuses(Collections.singleton(new Status(1, "Order processing")));
        orderRepository.save(order);
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
            orderItem.setProduct(orderItem.getProduct());
            orderItem.setCount(orderItem.getCount());
            orderItemRepository.save(orderItem);
        }
    }
}
