package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Account;
import springShop.service.impl.AccountServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @GetMapping
    public List<Account> getAll(){return accountServiceImpl.findAll();}

    @PostMapping
    public String deleteAccount(@RequestParam(required = true, defaultValue = "") Long accountId,
                                @RequestParam(required = true, defaultValue = "") String action,
                                Model model) {
        if (action.equals("delete")) {
            accountServiceImpl.deleteAccount(accountId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/gt/{accountId}")
    public List<Account> gtAccount(@PathVariable("accountId") Long accountId/*, Model model*/) {
        return accountServiceImpl.accountgtList(accountId);
        /*model.addAttribute("allAccounts",);
        return "";*/
    }

    @GetMapping("{accountId}")
    public ResponseEntity<Account> findOne (@PathVariable Long accountId) {
        return new ResponseEntity<>(accountServiceImpl.findById(accountId), HttpStatus.OK) ;
    }

}
