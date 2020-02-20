package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.OrderItemRepository;
import springShop.entity.OrderItem;
import springShop.service.OrderItemService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

//    @Override
//    public void save(ArrayList<OrderItem> orderItems) {
//        for (OrderItem orderItem : orderItems) {
//            orderItem.setId(ordId);
////            orderItem.setId(orderItemRepository.getTopByOrderByIdDesc());
//            orderItem.setProduct(orderItem.getProduct());
//            orderItem.setCount(orderItem.getCount());
//            orderItemRepository.save(orderItem);
//        }
//    }
}
