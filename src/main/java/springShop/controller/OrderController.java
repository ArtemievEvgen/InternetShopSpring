package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Order;
import springShop.repository.OrderRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findOne (@PathVariable Integer Id) {
        return new ResponseEntity<>(orderRepository.findById(Id), HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Integer id) {orderRepository.deleteById(id);
    }
}
