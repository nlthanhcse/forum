package ojt.thanhnl4.categoryservice.controller;

import ojt.thanhnl4.categoryservice.model.Category;
import ojt.thanhnl4.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping("/category/{categoryId}")
    public Category getById(@PathVariable(name = "categoryId") Integer categoryId) {
        return this.categoryService.getById(categoryId);
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        return this.categoryService.addCategory(category);
    }

    @DeleteMapping("/category/{categoryId}")
    public Category deleteById(@PathVariable(name = "categoryId") Integer categoryId) {
        return this.categoryService.deleteById(categoryId);
    }
}
