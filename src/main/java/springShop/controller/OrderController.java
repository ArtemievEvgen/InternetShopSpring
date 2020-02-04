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
    public ResponseEntity<?> findOne (@PathVariable Integer orderId) {
        return new ResponseEntity<>(orderRepository.findById(orderId), HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Integer id) {orderRepository.deleteById(id);
    }
//
//    @GetMapping("/orders")
//    Resources<Resource<Order>> all() {
//
//        List<Resource<Order>> orders = orderRepository.findAll().stream()
//                .map(assembler::toResource)
//                .collect(Collectors.toList());
//
//        return new Resources<>(orders, linkTo(methodOn(OrderController.class).all()).withSelfRel());
//    }
//
//    @GetMapping("/orders/{id}")
//    Resource<Order> one(@PathVariable Long id) {
//        return assembler.toResource(
//                orderRepository.findById(id)
//                        .orElseThrow(() -> new OrderNotFoundException(id)));
//    }
//
//    @PostMapping("/orders")
//    ResponseEntity<Resource<Order>> newOrder(@RequestBody Order order) {
//
////        order.setStatus(Status.IN_PROGRESS);
//        Order newOrder = orderRepository.save(order);
//
//        return ResponseEntity
//                .created(linkTo(methodOn(OrderController.class).one(newOrder.getId())).toUri())
//                .body(assembler.toResource(newOrder));
//    }
//}
//
//    @PutMapping("/orders/{id}/complete")
//    ResponseEntity<ResourceSupport> complete(@PathVariable Long id) {
//
//        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
//
//        if (order.getStatus() == Status.IN_PROGRESS) {
//            order.setStatus(Status.COMPLETED);
//            return ResponseEntity.ok(assembler.toResource(orderRepository.save(order)));
//        }
//
//        return ResponseEntity
//                .status(HttpStatus.METHOD_NOT_ALLOWED)
//                .body(new VndErrors.VndError("Method not allowed", "You can't complete an order that is in the " + order.getStatus() + " status"));
//    }
//
//@DeleteMapping("/orders/{id}/cancel")
//ResponseEntity<ResourceSupport> cancel(@PathVariable Long id) {
//
//    Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
//
//    if (order.getStatus() == Status.IN_PROGRESS) {
//        order.setStatus(Status.CANCELLED);
//        return ResponseEntity.ok(assembler.toResource(orderRepository.save(order)));
//    }
//
//    return ResponseEntity
//            .status(HttpStatus.METHOD_NOT_ALLOWED)
//            .body(new VndErrors.VndError("Method not allowed", "You can't cancel an order that is in the " + order.getStatus() + " status"));
//}

}
