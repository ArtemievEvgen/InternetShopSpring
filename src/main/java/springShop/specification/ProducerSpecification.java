package springShop.specification;

import org.springframework.data.jpa.domain.Specification;
import springShop.entity.Product;

import java.text.MessageFormat;


public class ProducerSpecification {

    public static Specification<Product> producerContains(String name) {
        return (root, query, builder) -> builder.like(root.get("producer"), contains(String.valueOf(name)));
    }
    private static String contains(String s) {
        return MessageFormat.format("%{0}%", s);
    }
}