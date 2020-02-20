package springShop.service;


import springShop.entity.Order;
import springShop.entity.OrderItem;

import java.util.ArrayList;
import java.util.Optional;

public interface OrderService {

    Object findAll();

    Object findById(Integer id);

    void deleteById(Integer id);

//    void save(ArrayList<Order> order);

   Optional<Order> update(Order updateOrder, Integer id);

    void save(ArrayList<OrderItem> orderItems);
}
