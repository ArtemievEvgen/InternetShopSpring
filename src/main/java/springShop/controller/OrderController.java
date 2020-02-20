package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Order;
import springShop.entity.OrderItem;
import springShop.entity.Product;
import springShop.service.OrderItemService;
import springShop.service.OrderService;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;

@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findOne(@PathVariable Integer id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public HttpStatus createOrder(@RequestBody ArrayList<OrderItem> orderItems) {
        orderService.save(orderItems);
//        orderItemService.save(orderItems);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus updateOrder(@RequestBody Order updateOrder, @PathVariable Integer id) {
        orderService.update(updateOrder, id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Integer id) {
        orderService.deleteById(id);
    }

}
