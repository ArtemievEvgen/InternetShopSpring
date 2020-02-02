package springShop.dto;

import org.springframework.hateoas.RepresentationModel;
import springShop.entity.Account;
import java.util.Set;

public class RoleDTO extends RepresentationModel<RoleDTO> {

    private String name;
    private Set<Account> accounts;

    public RoleDTO() {
    }

    public RoleDTO(String name, Set<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
