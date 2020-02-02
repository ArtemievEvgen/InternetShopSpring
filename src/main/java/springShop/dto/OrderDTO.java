package springShop.dto;

import org.springframework.hateoas.RepresentationModel;
import springShop.entity.Account;

public class OrderDTO extends RepresentationModel<OrderDTO> {

    private Account account;
    private String created;
    private String checked;

    public OrderDTO() {
    }

    public OrderDTO(Account account, String created, String checked) {
        this.account = account;
        this.created = created;
        this.checked = checked;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
