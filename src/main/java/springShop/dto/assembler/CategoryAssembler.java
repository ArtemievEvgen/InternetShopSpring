package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.CategoryController;
import springShop.dto.CategoryDTO;
import springShop.entity.Category;

@Component
public class CategoryAssembler extends RepresentationModelAssemblerSupport<Category, CategoryDTO> {
    public CategoryAssembler() {
        super(CategoryController.class, CategoryDTO.class);
    }

    @Override
    public CategoryDTO toModel(Category entity) {
      CategoryDTO dto = createModelWithId(entity.getId(),entity);
//        dto.setLastName(entity.getLastName());
//        dto.add(linkTo(methodOn(AdminController.class).getAll()).withRel("get all"),
//                linkTo(methodOn(AdminController.class).deleteAccount(entity.getId())).withRel("delete"));
        return dto;
    }
}
