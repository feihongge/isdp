package edu.scau.mis.pos.mapper;


import edu.scau.mis.IsdpBootApplication;
import edu.scau.mis_pos.domain.Category;
import edu.scau.mis_pos.mapper.ICategoryMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)  // 是否回滚，设为false即会更新数据库，设为true则不会更新。
@ContextConfiguration(classes = IsdpBootApplication.class)
class ICategoryMapperTest {

    @Qualifier("ICategoryMapper")
    @Autowired
    private ICategoryMapper categoryMapper;

    @Test
    void selectCategoryById() {
        Category category = categoryMapper.selectCategoryById(1L);
        assertEquals("文具", category.getCategoryname());
    }

    @Test
    void selectAllCategoryList() {
        List<Category> categories = categoryMapper.selectAllCategoryList();
        assertEquals(3, categories.size());
    }
}
/**
    @Test
    void selectCategoryList() {
    }

    @Test
    void insertCategory() {
    }

    @Test
    void updateCategory() {
    }

    @Test
    void deleteCategoryById() {
    }
}
 */