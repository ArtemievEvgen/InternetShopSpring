package springShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springShop.repository.CategoryRepository;
import springShop.entity.Category;

import java.util.List;

@Service
public class CategoryServiceImpl {
    @Autowired
    private CategoryRepository categoryRepository;

}
