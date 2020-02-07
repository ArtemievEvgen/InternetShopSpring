package springShop.service;

import springShop.entity.Account;

public interface AccountService  {
    void save(Account account);

    Account update(Account newAccount, Integer id);

    Account updateAdmin(Account newAccount, Integer id);

    public Account findById(Integer id);

}
