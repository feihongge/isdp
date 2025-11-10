package edu.scau.mis_pos.mapper;

import edu.scau.mis_pos.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Primary
public interface ICategoryMapper {

    @Select("SELECT category_id,parent_id,category_name FROM pos_category WHERE category_id = #{categoryId}")
    Category selectCategoryById(Long categoryId);

    @Select("SELECT category_id, parent_id, category_name FROM pos_category")
    @Results({
            @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="category_name", property="categoryname", jdbcType=JdbcType.VARCHAR),
            @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT)
    })
    List<Category> selectAllCategoryList();

    @Select("SELECT category_id, parent_id, category_name FROM pos_category")
    @Results({
            @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="category_name", property="categoryname", jdbcType=JdbcType.VARCHAR),
            @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT)
    })
    List<Category> selectCategoryList(Category category);
    int insertCategory(Category category);
    int updateCategory(Category category);
    int deleteCategoryById(Long id);
}
