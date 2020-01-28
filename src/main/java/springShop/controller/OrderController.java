package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springShop.entity.Order;
import springShop.service.impl.OrderServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
   private OrderServiceImpl orderServiceImpl;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(orderServiceImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findOne (@PathVariable Integer orderId) {
        return new ResponseEntity<>(orderServiceImpl.findById(orderId), HttpStatus.OK) ;
    }
//    @PostMapping("/order/{orderId}")
//    public  List<Order> get


}
