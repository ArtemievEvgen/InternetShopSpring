package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springShop.service.impl.AccountServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @GetMapping
    public String accountList(Model model) {
        model.addAttribute("findAll", accountServiceImpl.findAll());
        return "admin";
    }

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
    public String gtAccount(@PathVariable("accountId") Long accountId, Model model) {
        model.addAttribute("allAccounts", accountServiceImpl.accountgtList(accountId));
        return "";
    }

}
