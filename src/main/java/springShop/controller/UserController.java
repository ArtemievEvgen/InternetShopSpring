package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Account;
import springShop.repository.AccountRepository;
import springShop.service.AccountService;
import springShop.service.SecurityService;
import springShop.validator.UserValidator;

import java.net.URI;


@RestController
public class UserController {
    @Autowired
    SecurityService securityService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Account account) {
        return "add-account";
    }

    @PostMapping("/addAccount")
    public ResponseEntity<?> addAccount(@RequestBody Account account, BindingResult bindingResult) {
        userValidator.validate(account, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        accountService.save(account);
        securityService.autoLogin(account.getUsername(), account.getPasswordConfirm());
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<?> showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + id));

        model.addAttribute("account", account);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable("id") Integer id, @RequestBody Account newAccount
                                        ) {
        Account updatedAccount = accountRepository.findById(id).map(account -> {
            account.setName(newAccount.getName());
            account.setRole(newAccount.getRole());
            return accountRepository.save(account);
        })
                .orElseGet(() -> {
                    newAccount.setId(id);
                    return accountRepository.save(newAccount);
                });
        Resource<Account> resource = assembler.toResource(updatedAccount);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);/*.orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + id));*/
//        if (result.hasErrors()) {
//            account.setId(id);
//            return new ResponseEntity<String>("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
//        }

//        accountService.saveUpdate( updateAccount );
//        model.addAttribute("account", accountRepository.findAll());
//        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }



    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable("id") Integer id, Model model) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + id));
        accountRepository.delete(account);
        model.addAttribute("accounts", accountRepository.findAll());
        return "index";
    }
}
