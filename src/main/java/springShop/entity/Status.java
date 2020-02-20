package springShop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "status")
public class Status {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Transient

    @ManyToMany(mappedBy = "statuses")
    private Set<Order> orders;

    public Status(Integer id) {
        this.id = id;
    }

    public Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
