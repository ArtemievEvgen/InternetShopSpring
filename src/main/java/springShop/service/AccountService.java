package springShop.service;

import springShop.entity.Account;

public interface AccountService  {
    void save(Account account);

//    Account update(Integer id,Account account);

//    void saveUpdate(int id,Account account);

    Account update(Account account,int id);

    Account findByUsername(String username);
}
