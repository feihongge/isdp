package edu.scau.mis_pos.service;

import edu.scau.mis.common.annotation.Lowercase;
import edu.scau.mis_pos.domain.Category;

import java.util.List;
@Lowercase
public interface ICategoryService {

    List<Category> CATEGORIES = List.of();

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();

    List<Category> getCategories(Category category);

    int addCategory(Category category);

    int updateCategory(Category category);

    int deleteCategory(Long categoryId);
}
