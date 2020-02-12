package springShop.dto;

import org.springframework.hateoas.RepresentationModel;
import springShop.entity.Category;
import springShop.entity.Producer;


public class ProductDTO extends RepresentationModel<ProductDTO> {

    private String description;
    private String imageLink;
    private Double price;
    private CategoryDTO category;
    private ProducerDTO producer;

    public ProductDTO() {
    }

    public ProductDTO(String description, String imageLink, Double price, CategoryDTO category, ProducerDTO producer) {
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public ProducerDTO getProducer() {
        return producer;
    }

    public void setProducer(ProducerDTO producer) {
        this.producer = producer;
    }
}
