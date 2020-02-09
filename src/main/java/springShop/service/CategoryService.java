package springShop.service;

import springShop.entity.Category;

import java.util.List;

public interface CategoryService {
    Category update(Category newCategory, Integer id);

    List<Category> findAll();

    void deleteById(Integer id);
}
