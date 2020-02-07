package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.AccountController;
import springShop.dto.AccountDTO;
import springShop.entity.Account;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class AccountAssembler extends RepresentationModelAssemblerSupport<Account, AccountDTO> {

    public AccountAssembler() {
        super(AccountController.class, AccountDTO.class);
    }

    @Override
    public AccountDTO toModel(Account entity) {
        AccountDTO dto = createModelWithId(entity.getId(),entity);
        dto.setUserName(entity.getUsername());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setZip(entity.getZip());
        dto.add(linkTo(methodOn(AccountController.class).getAll(null, null)).withRel("get all"),
                linkTo(methodOn(AccountController.class).deleteAccount(entity.getId())).withRel("delete"));
        return dto;
    }
}
