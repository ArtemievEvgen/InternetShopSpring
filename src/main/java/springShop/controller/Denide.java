package springShop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import java.security.Principal;

@RestController
public class Denide {

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(/*Model model, */Principal principal) {

        String userInfo = null;

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            userInfo = loginedUser.toString();



            /*model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);*/

        }

        return "Access DENIED for user " + userInfo;
    }
}
