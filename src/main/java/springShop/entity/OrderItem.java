package springShop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_item")

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    @Column( name = "count")
    private Integer count;


//    public Integer getId(Order order) {
//        return order.getId();
//    }
//    public Integer getOrder(Order order) {
//        return order.getId();
//    }
//    public Integer getProduct( Product product) {
//        return product.getId();
//    }
//
//    public Product setId(OrderItem orderItem) {
//    }
}

