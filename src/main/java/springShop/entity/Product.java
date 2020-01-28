package springShop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
//
//   @ManyToMany(fetch = FetchType.EAGER)
//    private Set<Order> order;


    public Product() {
    }
    public Product(Category category,Producer producer, String name, Double price){
        this.category = category;
        this.producer = producer;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

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
