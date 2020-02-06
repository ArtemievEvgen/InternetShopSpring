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
import springShop.specification.dao.AccountSpecification;
import springShop.specification.dao.AccountSpecificationsBuilder;
import springShop.specification.dao.GenericSpecificationsBuilder;
import springShop.specification.util.CriteriaParser;
import springShop.specification.util.SearchCriteria;
import springShop.specification.util.SearchOperation;
import springShop.validator.UserValidator;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    public String registration(@RequestBody Account accountForm, BindingResult bindingResult) {
        userValidator.validate(accountForm, bindingResult);
        accountService.save(accountForm);
        securityService.autoLogin(accountForm.getUsername(), accountForm.getPasswordConfirm());
        return "redirect:/welcome";
    }

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping("/allAccounts")
    public List<Account> getAll() {
        return accountRepository.findAll();
    }
    @RolesAllowed("ROLE_ADMIN")
    @GetMapping("/{id}")
    public AccountDTO Account(@PathVariable("id") Integer id) {
        Account account = accountService.findById(id);
        AccountDTO dto = new AccountAssembler().toModel(account);
        return dto; }
//    @RolesAllowed("ROLE_ADMIN")
//    @GetMapping("/{accountRole}")
//    public ResponseEntity<?> getAccountByRoles (@PathVariable String accountRole){
//        return new ResponseEntity<>(accountRepository.accountRoleList(accountRole), HttpStatus.OK);
//    }

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
        return HttpStatus.OK;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    @ResponseBody
    public List<Account> search(@RequestParam(value = "search", required = false) String search) {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return accountService.searchUser(params);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/accounts/spec")
    @ResponseBody
    public List<Account> findAllBySpecification(@RequestParam(value = "search") String search) {
        AccountSpecificationsBuilder builder = new AccountSpecificationsBuilder();
        String operationSetExper = Joiner.on("|")
                .join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
        }

        Specification<Account> spec = builder.build();
        return accountRepository.findAll(spec);
    }

    @GetMapping(value = "/users/espec")
    @ResponseBody
    public List<Account> findAllByOrPredicate(@RequestParam(value = "search") String search) {
        Specification<Account> spec = resolveSpecification(search);
        return accountRepository.findAll(spec);
    }

    @GetMapping(value = "/users/spec/adv")
    @ResponseBody
    public List<Account> findAllByAdvPredicate(@RequestParam(value = "search") String search) {
        Specification<Account> spec = resolveSpecificationFromInfixExpr(search);
        return accountRepository.findAll(spec);
    }

    protected Specification<Account> resolveSpecificationFromInfixExpr(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<Account> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), AccountSpecification::new);
    }

    protected Specification<Account> resolveSpecification(String searchParameters) {

        AccountSpecificationsBuilder builder = new AccountSpecificationsBuilder();
        String operationSetExper = Joiner.on("|")
                .join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\p{Punct}?)(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(searchParameters + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(5), matcher.group(4), matcher.group(6));
        }
        return builder.build();
    }


}
