package springShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springShop.entity.Category;
import springShop.repository.CategoryRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RolesAllowed("ROLE_ADMIN")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @DeleteMapping("/{categoryId}")
    void deleteCategory(@PathVariable Integer id) {
        categoryRepository.deleteById(id);
    }
}
