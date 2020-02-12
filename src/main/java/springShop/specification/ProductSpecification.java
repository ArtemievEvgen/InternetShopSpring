package springShop.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import springShop.entity.Category;
import springShop.entity.Producer;
import springShop.entity.Product;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.text.MessageFormat;
import java.util.Arrays;

@Component
public class ProductSpecification {



    public static Specification<Product> descriptionContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("description"), contains(expression));
    }

    public static Specification<Product> nameContains(String expression) {
        return (root, query, builder) -> builder.like(root.get("name"), contains(expression));
    }

    public static Specification<Product> priceIn(Double... values) {
        return (root, query, builder) -> builder.or(Arrays
                .stream(values)
                .map(value -> builder.equal(root.get("price"), value))
                .toArray(Predicate[]::new));
    }

    public static Specification<Product> categoryContains(String expression) {
        return (root, query, builder) -> {
            Join<Product, Category> categoryJoin = root.join("category");
            return builder.like(categoryJoin.<String>get("name"), contains(expression));
        };
    }
    public static Specification<Product> producerContains(String expression) {
        return (root, query, builder) -> {
            Join<Product, Producer> producerJoin = root.join("producer");
            return builder.like(producerJoin.<String>get("name"), contains(expression));
        };
    }

    private static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }


    ///////////////////////////////////////////////////


}

