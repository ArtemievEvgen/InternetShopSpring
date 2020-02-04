package springShop.service;

import springShop.entity.Account;
import springShop.repository.AccountRepository;

public interface AccountService  {
    void save(Account account);

    Account update(Account newAccount, Integer id);


}
