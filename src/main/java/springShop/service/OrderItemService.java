package springShop.service;


import springShop.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> findAll();
}
