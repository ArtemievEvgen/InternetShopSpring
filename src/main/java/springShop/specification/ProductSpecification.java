package springShop.specification;

import org.springframework.data.jpa.domain.Specification;
import springShop.entity.Product;

import java.text.MessageFormat;

public class ProductSpecification {
    public static Specification<Product> descriptionContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("description"), contains(expression));
    }
    public static Specification<Product> nameContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("name"), contains(expression));
    }
    public static Specification<Product> priceContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("price"), contains(expression));
    }
    public static Specification<Product> categoryContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("category"), contains(expression));
    }
    public static Specification<Product> producerContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("producer"), contains(expression));
    }
    private static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }
}

