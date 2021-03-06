package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService,UserDetailsService {

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

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<Account> findAll(Specification<Account> specification) {
        return accountRepository.findAll(specification);
    }
}
