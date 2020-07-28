package ojt.thanhnl4.categoryservice.service;

import ojt.thanhnl4.categoryservice.model.Category;
import ojt.thanhnl4.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        return this.categoryRepository.findCategoryById(id);
    }

    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category deleteById(Integer id) {
        return this.categoryRepository.deleteCategoryById(id);
    }
}
