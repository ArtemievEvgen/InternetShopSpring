package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.AdminController;
import springShop.dto.AccountDTO;
import springShop.entity.Account;
@Component
public class AccountAssembler extends RepresentationModelAssemblerSupport<Account, AccountDTO> {

    public AccountAssembler() {
        super(AdminController.class, AccountDTO.class);
    }

    @Override
    public AccountDTO toModel(Account entity) {
        AccountDTO dto = createModelWithId(entity.getId(),entity);
        dto.setLastName(entity.getLastName());
//        dto.add(linkTo(methodOn(AdminController.class).getAll()).withRel("get all"),
//                linkTo(methodOn(AdminController.class).deleteAccount(entity.getId())).withRel("delete"));
        return dto;
    }
}
