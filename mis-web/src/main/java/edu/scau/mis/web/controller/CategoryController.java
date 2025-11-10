package edu.scau.mis.web.controller;

import edu.scau.mis.common.web.domain.ApiResult;
import edu.scau.mis_pos.domain.Category;
import edu.scau.mis_pos.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/{categoryId}")
    public ApiResult<Category> getById(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return category == null ? ApiResult.noContent() : ApiResult.success(category);
    }

    @GetMapping("/listAll")
    public ApiResult<List<Category>> listAll() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories == null || categories.isEmpty()) {
            return ApiResult.noContent();
        }
        return ApiResult.success(categories);
    }

    @GetMapping("/listByParams")
    public ApiResult<List<Category>> listByParams(Category query) {
        List<Category> categories = categoryService.getCategories(query);
        return categories.isEmpty() ? ApiResult.noContent() : ApiResult.success(categories);
    }

    @PostMapping("/add")
    public Category add(
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("categoryName") String categoryName
    ) { return new Category(categoryId, 0L,categoryName);}



    @PutMapping("/update")
    public Category update(@RequestBody Category category) {
        return category;
    }

    @DeleteMapping("/delete/{categoryId}")
    public HashMap<String, Object> delete(@PathVariable("categoryId") Long categoryId)
    {
        HashMap<String, Object> result = new HashMap<>();
        result.put("data", categoryId);
        return result;
    }
}
