package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springShop.dto.AccountDTO;
import springShop.dto.assembler.AccountAssembler;
import springShop.entity.Account;
import springShop.repository.AccountRepository;
import springShop.service.AccountService;
import springShop.service.impl.AccountServiceImpl;
import springShop.validator.UserValidator;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RolesAllowed("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @PostMapping("/newAccount")
    public Account newAccount(@RequestBody Account accountForm, BindingResult bindingResult) {
        userValidator.validate(accountForm, bindingResult);
        accountService.save(accountForm);
        return accountForm;
    }

    @GetMapping("/{id}")
    public AccountDTO Account(@PathVariable("id") Integer id) {
        Account account = accountServiceImpl.findById(id);
        AccountDTO dto = new AccountAssembler().toModel(account);
        return dto;
    }

    @PutMapping("/account/{id}")
    public Account updateAccount(@RequestBody Account newAccount, @PathVariable Integer id) {
        Account updatedAccount = accountService.update(newAccount,id);
        return updatedAccount;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id) {

        accountRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
