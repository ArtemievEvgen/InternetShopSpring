package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Account;
import springShop.entity.Role;
import springShop.repository.RoleRepository;
import springShop.service.impl.RoleServiceImpl;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
