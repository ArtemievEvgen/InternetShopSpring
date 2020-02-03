package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springShop.dto.AccountDTO;
import springShop.dto.assembler.AccountAssembler;
import springShop.entity.Account;
import springShop.repository.AccountRepository;
import springShop.service.AccountService;
import springShop.service.impl.AccountServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @PostMapping("/newAccount")
    public Account newAccount(@RequestBody Account newAccount) {
        return accountRepository.save(newAccount);
    }

    @GetMapping("/Account/{id}")
    public AccountDTO Account(@PathVariable("id") Integer id) {
        Account account = accountServiceImpl.findById(id);
        AccountDTO dto = new AccountAssembler().toModel(account);
        return dto;
    }

    @PutMapping("/account/{id}")
    public Account updateAccount(@RequestBody Account newAccount, @PathVariable Integer id) {
        accountService.update(newAccount,id);
        return newAccount;
    }

    @DeleteMapping("/{id}")
    void deleteAccount(@PathVariable Integer id) {
        accountRepository.deleteById(id);
    }
}
