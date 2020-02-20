package springShop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Column(name = "image_link")
    private String imageLink;
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producer")
    private Producer producer;

    public String getCategory() {
        return category.getName();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProducer() {
        return producer.getName();
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
