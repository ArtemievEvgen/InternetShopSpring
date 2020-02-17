package springShop.service;

import org.springframework.data.jpa.domain.Specification;
import springShop.entity.Account;

import java.util.List;

public interface AccountService  {
    void save(Account account);

    Account update(Account newAccount, Integer id);

    Account updateAdmin(Account newAccount, Integer id);

    public Account findById(Integer id);

    void deleteById(Integer id);

    List<Account> findAll(Specification<Account> specification);

}
