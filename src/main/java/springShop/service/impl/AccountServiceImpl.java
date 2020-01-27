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

    public Account findAccountById(Long accountId) {
        Optional<Account> accountFromDb = accountRepository.findById(accountId);
        return accountFromDb.orElse(new Account());   //orElseThrow
    }


    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public boolean saveAccount(Account account) {
        Account accountFromDB = accountRepository.findByUsername(account.getUsername());

        if (accountFromDB != null) {
            return false;
        }

//        account.setRoles();
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
        return true;
    }

    @Override
    public void save(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }


    public boolean deleteAccount(Long accountId) {
        if (accountRepository.findById(accountId).isPresent()) {
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }

    public List<Account> accountgtList(Long idMin) {
        return accountRepository.accountList(idMin);
    }


    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }


}
