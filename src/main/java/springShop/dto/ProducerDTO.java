package springShop.dto;

import org.springframework.hateoas.RepresentationModel;

public class ProducerDTO extends RepresentationModel<ProducerDTO> {

    private Integer id;
    private String name;
    private Integer productCount;

    public ProducerDTO() {
    }

    public ProducerDTO(Integer id, String name, Integer productCount) {
        this.id = id;
        this.name = name;
        this.productCount = productCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}
