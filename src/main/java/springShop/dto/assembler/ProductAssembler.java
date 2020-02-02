package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.ProductController;
import springShop.dto.ProductDTO;
import springShop.entity.Product;
@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<Product, ProductDTO> {
    public ProductAssembler(){ super (ProductController.class,ProductDTO.class);}

    @Override
    public  ProductDTO toModel(Product entity){
        ProductDTO dto = createModelWithId(entity.getId(),entity);
        return dto;
    }
}
