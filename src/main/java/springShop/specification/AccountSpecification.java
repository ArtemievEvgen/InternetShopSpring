package springShop.specification;

import org.springframework.data.jpa.domain.Specification;
import springShop.entity.Account;

import java.text.MessageFormat;

public class AccountSpecification {
    public static Specification<Account> firstNameContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("firstName"), contains(expression));
    }

    public static Specification<Account> lastNameContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("lastName"), contains(expression));
    }

    private static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }
}
