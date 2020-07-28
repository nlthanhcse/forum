package ojt.thanhnl4.categoryservice.repository;

import ojt.thanhnl4.categoryservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();
    Category findCategoryById(Integer id);
    Category deleteCategoryById(Integer id);
}
