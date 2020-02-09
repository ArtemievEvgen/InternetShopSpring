package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.RoleRepository;
import springShop.entity.Role;
import springShop.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role update(Role newRole, Integer id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
