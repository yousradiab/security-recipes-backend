package dat3.recipe.api;


import dat3.recipe.dto.CategoryDto;
import dat3.recipe.entity.Category;
import dat3.recipe.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<String> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryDto request)
    {return categoryService.addCategory(request);
    };
}
