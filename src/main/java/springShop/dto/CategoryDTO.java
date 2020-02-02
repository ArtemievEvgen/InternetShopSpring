package springShop.dto;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;


public class CategoryDTO extends RepresentationModel<CategoryDTO> {

    private String name;
    private String url;
    private Integer productCount;

    public CategoryDTO() {
    }

    public CategoryDTO(String name, String url, Integer productCount) {
        this.name = name;
        this.url = url;
        this.productCount = productCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}
