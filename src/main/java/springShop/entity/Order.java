package springShop.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_account")
    private Account idAccount;

    @Column(name = "created")
    private Timestamp created;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Status> statuses;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "order_product")
//    private Set<Product> products ;

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }

}
