package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
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
import springShop.service.AccountService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.MessageFormat;
import java.util.*;
import java.util.function.Predicate;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class AccountServiceImpl implements AccountService,UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

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

   @Override
    public void save(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        accountRepository.save(account);
    }

    @Override
    public Account update(Account newAccount, Integer id) {
        return accountRepository.findById(id)
                .map(account -> {
                    account.setFirstName(newAccount.getFirstName());
                    account.setLastName(newAccount.getLastName());
                    account.setPhoneNumber(newAccount.getPhoneNumber());
                    account.setAddress(newAccount.getAddress());
                    account.setCity(newAccount.getCity());
                    account.setCountry(newAccount.getCountry());
                    account.setZip(newAccount.getZip());
                    return accountRepository.save(account);
                })
                .orElseGet(() -> {
                    newAccount.setId(id);
                    return accountRepository.save(newAccount);
                });
    }

    @Override
    public Account updateAdmin(Account newAccount, Integer id) {
        return accountRepository.findById(id)
                .map(account -> {
                    account.setRoles(newAccount.getRoles());
                    return accountRepository.save(account);
                })
                .orElseGet(() -> {
                    newAccount.setId(id);
                    return accountRepository.save(newAccount);
                });
    }

    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

}
