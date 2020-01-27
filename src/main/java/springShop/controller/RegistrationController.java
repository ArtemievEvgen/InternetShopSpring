package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Account;
import springShop.service.AccountService;
import springShop.service.SecurityService;
import springShop.service.impl.AccountServiceImpl;
import springShop.validator.UserValidator;

import javax.validation.Valid;

//@RestController
//@RequestMapping("/registration")
//public class RegistrationController {
//    @Autowired
//    private AccountServiceImpl accountServiceImpl;
//
//    @GetMapping
//    public String registration(Model model) {
//        model.addAttribute("accountForm", new Account());
//
//        return "registration";
//    }
//
//    @PostMapping
//    public String addAccount(@ModelAttribute("accountForm") @Valid Account accountForm, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "registration1";
//        }
//        if (!accountForm.getPassword().equals(accountForm.getPasswordConfirm())) {
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration2";
//        }
//        if (!accountServiceImpl.saveAccount(accountForm)) {
//            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
//            return "registration3";
//        }
//
//        return "redirect:/";
//    }
//}

@RestController
@RequestMapping
public class RegistrationController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("accountForm", new Account());
//
//        return "registration";
//    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("accountForm") Account accountForm, BindingResult bindingResult) {
        userValidator.validate(accountForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        accountService.save(accountForm);

        securityService.autoLogin(accountForm.getUsername(), accountForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @PostMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}