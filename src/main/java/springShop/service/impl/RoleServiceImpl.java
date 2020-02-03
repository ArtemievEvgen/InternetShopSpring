package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.RoleRepository;
import springShop.entity.Role;

import java.util.List;

@Service
public class RoleServiceImpl {
    @Autowired
    private RoleRepository roleRepository;
}
