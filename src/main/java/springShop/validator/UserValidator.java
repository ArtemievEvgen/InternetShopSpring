package springShop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import springShop.entity.Account;
import springShop.repository.AccountRepository;
import springShop.service.AccountService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Account account = (Account) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (account.getUsername().length() < 6 || account.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.accountForm.username");
        }

        if (accountRepository.findByUsername(account.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.accountForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (account.getPassword().length() < 3 || account.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.accountForm.password");
        }

        if (!account.getPasswordConfirm().equals(account.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.accountForm.passwordConfirm");
        }
    }
}
