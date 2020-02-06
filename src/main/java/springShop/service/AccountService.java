package springShop.service;

import springShop.entity.Account;
import springShop.repository.AccountRepository;
import springShop.specification.util.SearchCriteria;

import java.util.List;

public interface AccountService  {
    void save(Account account);

    Account update(Account newAccount, Integer id);

    Account updateAdmin(Account newAccount, Integer id);

    public Account findById(Integer id);

    List<Account> searchUser(List<SearchCriteria> params);
}
