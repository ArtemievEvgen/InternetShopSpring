package springShop.dto;

import org.springframework.hateoas.RepresentationModel;
import springShop.entity.Category;
import springShop.entity.Producer;


public class ProductDTO extends RepresentationModel<ProductDTO> {

    private String description;
    private String imageLink;
    private Double price;
    private Category category;
    private Producer producer;

    public ProductDTO() {
    }

    public ProductDTO(String description, String imageLink, Double price, Category category, Producer producer) {
        this.description = description;
        this.imageLink = imageLink;
        this.price = price;
        this.category = category;
        this.producer = producer;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
