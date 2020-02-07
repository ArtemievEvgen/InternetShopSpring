package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springShop.dto.AccountDTO;
import springShop.dto.assembler.AccountAssembler;
import springShop.entity.Account;
import springShop.repository.AccountRepository;
import springShop.service.AccountService;
import springShop.service.SecurityService;
import springShop.specification.AccountSpecification;
import springShop.validator.UserValidator;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {
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



    @PostMapping("/registration")
    public HttpStatus registration(@RequestBody Account accountForm, BindingResult bindingResult) {
        userValidator.validate(accountForm, bindingResult);
        accountService.save(accountForm);
        securityService.autoLogin(accountForm.getUsername(), accountForm.getPasswordConfirm());
        return HttpStatus.OK;
    }

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping
    public List<Account> getAll(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName) {
        Specification<Account> specification = Specification
                // firstName from parameter
                .where(firstName == null ? null : AccountSpecification.firstNameContains(firstName))
                // lastName from parameter
                .and(lastName == null ? null : AccountSpecification.lastNameContains(lastName));
        return accountRepository.findAll(specification);
    }

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping("/{id}")
    public AccountDTO Account(@PathVariable("id") Integer id) {
        Account account = accountService.findById(id);
        AccountDTO dto = new AccountAssembler().toModel(account);
        return dto; }


    @RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping("/{id}")
    public Account updateAccount(@RequestBody Account newAccount, @PathVariable Integer id) {
        Account updatedAccount = accountService.update(newAccount,id);
        return updatedAccount;
    }

    @RolesAllowed("ROLE_ADMIN")
    @PutMapping("/admin/{id}")
    public Account updateAdminAccount(@RequestBody Account newAccount, @PathVariable Integer id) {
        Account updatedAccount = accountService.updateAdmin(newAccount,id);
        return updatedAccount;
    }

    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping("/{id}")
   public HttpStatus deleteAccount(@PathVariable Integer id) {
        accountRepository.deleteById(id);
        return null;
    }
}
