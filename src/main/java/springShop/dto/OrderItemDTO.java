package springShop.dto;

import org.springframework.hateoas.RepresentationModel;
import springShop.entity.Order;
import springShop.entity.Product;


public class OrderItemDTO extends RepresentationModel<OrderItemDTO> {

    private Order order;
    private Product product;
    private Integer count;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Order order, Product product, Integer count) {
        this.order = order;
        this.product = product;
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
