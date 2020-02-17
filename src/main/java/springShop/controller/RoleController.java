package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springShop.entity.Role;
import springShop.service.RoleService;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll() {
        return roleService.findAll();
    }
}
