package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import springShop.entity.Account;
import springShop.repository.CategoryRepository;
import springShop.entity.Category;
import springShop.service.AccountService;
import springShop.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category update(Category newCategory, Integer id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    category.setUrl(newCategory.getUrl());
                    category.setProductCount(newCategory.getProductCount());
                    return categoryRepository.save(category);
                })
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return categoryRepository.save(newCategory);
                });
    }
}
