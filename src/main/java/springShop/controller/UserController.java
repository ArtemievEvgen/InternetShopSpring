package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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
    public ResponseEntity<EntityModel<Account>> newAccount(@RequestBody Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount.getId() //
                .map(id -> ResponseEntity.created( //
                        linkTo(methodOn(UserController.class).findOne(id)).toUri()).body(assembler.toModel(savedAccount)))
                .orElse(ResponseEntity.notFound().build());
    }



    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable("id") Integer id, Model model) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + id));
        accountRepository.delete(account);
        model.addAttribute("accounts", accountRepository.findAll());
        return "index";
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        accountRepository.deleteById(id);
    }
}
