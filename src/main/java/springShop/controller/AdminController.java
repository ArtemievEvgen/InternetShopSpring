package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springShop.dto.assembler.AccountAssembler;
import springShop.dto.AccountDTO;
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

    @GetMapping("/{accountId}")
    public AccountDTO gtAccount(@PathVariable("accountId") Integer accountId/*, Model model*/) {
        Account account = accountServiceImpl.findById(accountId);
        AccountDTO dto = new AccountAssembler().toModel(account);
        return dto;
        /*model.addAttribute("allAccounts",);
        return "";*/
    }

//    @GetMapping("{accountId}")
//    public ResponseEntity<?> findOne (@PathVariable Integer accountId) {
//        return new ResponseEntity<>(accountServiceImpl.findById(accountId), HttpStatus.OK) ;
//    }

    @PostMapping
    public String deleteAccount(@RequestParam(required = true, defaultValue = "") Integer accountId,
                                @RequestParam(required = true, defaultValue = "") String action,
                                Model model) {
        if (action.equals("delete")) {
            accountServiceImpl.deleteAccount(accountId);
        }
        return "redirect:/admin";
    }






}
