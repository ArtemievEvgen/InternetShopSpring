package springShop.service;

import springShop.entity.Role;

import java.util.List;

public interface RoleService {
   Role update(Role newRole, Integer id);

    List<Role> findAll();
}
