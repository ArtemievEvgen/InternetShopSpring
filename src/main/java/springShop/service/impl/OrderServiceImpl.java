package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import springShop.entity.Account;
import springShop.entity.Status;
import springShop.repository.AccountRepository;
import springShop.repository.OrderRepository;
import springShop.entity.Order;
import springShop.service.OrderService;

import java.sql.Timestamp;
import java.util.Collections;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
@Autowired
private AccountRepository accountRepository;

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

    @Override
    public void save(Order order) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order.setIdAccount(accountRepository.findByUsername(user.getUsername()));
        order.setCreated(new Timestamp(System.currentTimeMillis()));
        order.setStatuses(Collections.singleton(new Status(1, "Order processing")));
        orderRepository.save(order);
    }

    @Override
    public void update(Order updateOrder,Integer id) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatuses();
                    return accountRepository.save(account);
                })
                .orElseGet(() -> {
                    newAccount.setId(id);
                    return accountRepository.save(newAccount);
                });
    }


}
