package dat3.recipe.service;

import dat3.recipe.api.CategoryController;
import dat3.recipe.dto.CategoryDto;
import dat3.recipe.entity.Category;
import dat3.recipe.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<String> getAllCategories() {
        List<Category> categories =  categoryRepository.findAll();
        //Convert from list of Categories to DTO-type, list of Strings
        return categories.stream().map((c)->new String(c.getName())).toList();
    }

    public Category addCategory(CategoryDto category) {
        System.out.println(category);
        Category newCategory = new Category(category.getName() );
        System.out.println(newCategory);
        return categoryRepository.save(newCategory);
    }
}

