package springShop.service;


import springShop.entity.Order;

public interface OrderService {
    Order update(Order newOrder, Integer id);
}
