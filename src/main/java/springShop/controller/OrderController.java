package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Order;
import springShop.repository.OrderRepository;
import springShop.service.OrderService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findOne (@PathVariable Integer id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Integer id) {orderService.deleteById(id);
    }
}
