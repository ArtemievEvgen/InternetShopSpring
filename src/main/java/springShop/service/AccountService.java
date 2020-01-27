package springShop.service;

import springShop.entity.Account;

public interface AccountService  {
    void save(Account account);

    Account findByUsername(String username);
}
