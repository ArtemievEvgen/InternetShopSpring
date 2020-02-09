package springShop.service;


import springShop.entity.Order;

public interface OrderService {
    Order update(Order newOrder, Integer id);

    Object findAll();

    Object findById(Integer id);

    void deleteById(Integer id);
}
