package ojt.thanhnl4.categoryservice.controller;

import ojt.thanhnl4.categoryservice.dto.UserDTO;
import ojt.thanhnl4.categoryservice.feignService.UserFeignService;
import ojt.thanhnl4.categoryservice.model.Category;
import ojt.thanhnl4.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/")
    public List<Category> getAll() {
        List<UserDTO> userDTOS = this.userFeignService.getAll();
        userDTOS.forEach(userDTO -> System.out.println(userDTO.getName()));
        return this.categoryService.getAll();
    }

    @GetMapping("/category/{category_id}")
    public Category getById(@PathVariable(name = "category_id") Integer category_id) {
        return this.categoryService.getById(category_id);
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        return this.categoryService.addCategory(category);
    }

    @DeleteMapping("/category/{category_id}")
    public Category deleteById(@PathVariable(name = "category_id") Integer category_id) {
        return this.categoryService.deleteById(category_id);
    }
}
