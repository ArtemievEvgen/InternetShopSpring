package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Account;
import springShop.entity.Order;
import springShop.service.OrderService;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

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

    @PostMapping
    public HttpStatus createOrder( @RequestBody Order orderForm){
        orderService.save(orderForm);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus updateorder(@RequestBody Order updateOrder, @PathVariable Integer id){
        orderService.update(updateOrder,id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Integer id) {orderService.deleteById(id);
    }

}
