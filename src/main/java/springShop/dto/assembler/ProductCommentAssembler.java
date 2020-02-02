package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.ProductCommentController;
import springShop.dto.ProductCommentDTO;
import springShop.entity.ProductComment;
@Component
public class ProductCommentAssembler extends RepresentationModelAssemblerSupport<ProductComment, ProductCommentDTO> {
    public ProductCommentAssembler() {
        super(ProductCommentController.class, ProductCommentDTO.class);
    }

    @Override
    public ProductCommentDTO toModel(ProductComment entity) {
        ProductCommentDTO dto = createModelWithId(entity.getId(),entity);
        return dto;
    }
}
