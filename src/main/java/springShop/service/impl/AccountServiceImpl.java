package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springShop.entity.Account;
import springShop.entity.Role;
import springShop.repository.AccountRepository;
import springShop.repository.RoleRepository;
import springShop.service.AccountService;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService,UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        if (account == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : account.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        return new User(account.getUsername(), account.getPassword(), grantedAuthorities);
    }

    public Account findAccountById(Integer accountId) {
        Optional<Account> accountFromDb = accountRepository.findById(accountId);
        return accountFromDb.orElse(new Account());   //orElseThrow
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account update(Account account, int id) {
        return accountRepository.save(account);
    }
//    @Override
//    public void saveUpdate(int id, Account account) {
//        account.setFirstName(account.getFirstName());
//        account.setLastName(account.getLastName());
//        account.setEmail(account.getEmail());
//        accountRepository.save(account);
//    }

   @Override
    public void save(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        accountRepository.save(account);
    }
    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public boolean deleteAccount(Integer accountId) {
        if (accountRepository.findById(accountId).isPresent()) {
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }

    public List<Account> accountgtList(Integer idMin) {
        return accountRepository.accountList(idMin);
    }

    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }


}
