package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.RoleController;
import springShop.dto.RoleDTO;
import springShop.entity.Role;

@Component
public class RoleAssembler extends RepresentationModelAssemblerSupport<Role, RoleDTO> {
    public RoleAssembler() {
        super(RoleController.class, RoleDTO.class);
    }

    @Override
    public RoleDTO toModel(Role entity) {
      RoleDTO dto = createModelWithId(entity.getId(),entity);
        return dto;
    }
}
