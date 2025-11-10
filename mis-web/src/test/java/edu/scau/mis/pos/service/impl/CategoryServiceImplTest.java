package edu.scau.mis.pos.service.impl;

import edu.scau.mis_pos.domain.Category;
import edu.scau.mis_pos.mapper.ICategoryMapper;
import edu.scau.mis_pos.service.ICategoryService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ICategoryMapper categoryMapper;

    @Test
    void getCategoryById() {
        Category category = categoryService.getCategoryById(1L);

        assertNotNull(category,"不存在该种类");
        System.out.println(category);
    }

    @Test
    void getAllCategories() {

       List<Category> category = categoryService.getAllCategories();
        System.out.println(category);
    }

    @org.junit.jupiter.api.Test
    void getCategories() {
        List<Category> category = categoryService.getCategories(new Category(4L, 0L,"食品"));
       assertNotNull(category,"不存在该种类");
        System.out.println(category);
    }

    @org.junit.jupiter.api.Test
    void addCategory() {
        int category = categoryMapper.insertCategory(new Category(4L, 0L,"食品"));
        System.out.println(category);
    }

    @org.junit.jupiter.api.Test
    void updateCategory() {
        int category = categoryMapper.updateCategory(new Category(4L,1L,"食品"));
        System.out.println(category);

    }

    @org.junit.jupiter.api.Test
    void deleteCategory() {
        int category = categoryMapper.deleteCategoryById(4L);
        System.out.println(category);
    }
}