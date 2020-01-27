package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springShop.entity.Role;
import springShop.service.impl.RoleServiceImpl;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @GetMapping("/role")
    public List<Role> getAll() {
        return roleServiceImpl.findAll();
    }
}
