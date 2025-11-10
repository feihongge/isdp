package edu.scau.mis_pos.service.impl;

import edu.scau.mis_pos.domain.Category;
import edu.scau.mis_pos.mapper.ICategoryMapper;
import edu.scau.mis_pos.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Service
@Primary
@Transactional
public class CategoryServiceImpl implements ICategoryService {


    @Qualifier("ICategoryMapper")
    @Autowired
    private ICategoryMapper categoryMapper;

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryMapper.selectCategoryById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> list = categoryMapper.selectAllCategoryList();
        return list == null ? Collections.emptyList() : list;
    }

    @Override
    public List<Category> getCategories(Category category) {
        return categoryMapper.selectCategoryList(category);
    }

    @Override
    public int addCategory(Category category) {
        return categoryMapper.insertCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategory(Long categoryId) {
        return categoryMapper.deleteCategoryById(categoryId);
    }



}
