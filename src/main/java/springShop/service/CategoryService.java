package springShop.service;

import springShop.entity.Category;

public interface CategoryService {
    Category update(Category newCategory, Integer id);
}
