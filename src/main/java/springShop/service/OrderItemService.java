package springShop.service;


import springShop.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public interface OrderItemService {

    List<OrderItem> findAll();

//    void save(ArrayList<OrderItem> orderItems);
}
