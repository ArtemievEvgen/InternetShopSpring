package springShop.service;


import springShop.entity.Order;

public interface OrderService {

    Object findAll();

    Object findById(Integer id);

    void deleteById(Integer id);

    void save(Order order);

    void update(Order updateOrder,Integer id);
}
