package edu.scau.mis_pos.mapper;

import edu.scau.mis_pos.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Primary;


import java.util.List;
@Mapper
@Primary
public interface IProductMapper {

    @Select("SELECT * FROM pos_product WHERE product_id = #{productId}")
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "product_sn", property = "productSn", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_name", property = "productName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_description", property = "productDescription", jdbcType = JdbcType.VARCHAR),
            @Result(column = "price", property = "price", jdbcType = JdbcType.DECIMAL),
            @Result(column = "product_category_id", property = "productCategoryId", jdbcType = JdbcType.BIGINT),
            @Result(column = "image_url", property = "imageUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "detail_url", property = "detailUrl", jdbcType = JdbcType.VARCHAR),

    })
    public Product selectProductById(Long productId);

    @Select("SELECT * FROM pos_product WHERE product_sn = #{productSn}")
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "product_sn", property = "productSn", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_name", property = "productName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_description", property = "productDescription", jdbcType = JdbcType.VARCHAR),
            @Result(column = "price", property = "price", jdbcType = JdbcType.DECIMAL),
            @Result(column = "product_category_id", property = "productCategoryId", jdbcType = JdbcType.BIGINT),
            @Result(column = "image_url", property = "imageUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "detail_url", property = "detailUrl", jdbcType = JdbcType.VARCHAR),

    })
    public Product selectProductBySn(String productSn);

    @Select("SELECT * FROM pos_product")
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "product_sn", property = "productSn", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_name", property = "productName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_description", property = "productDescription", jdbcType = JdbcType.VARCHAR),
            @Result(column = "price", property = "price", jdbcType = JdbcType.DECIMAL),
            @Result(column = "product_category_id", property = "productCategoryId", jdbcType = JdbcType.BIGINT),
            @Result(column = "image_url", property = "imageUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "detail_url", property = "detailUrl", jdbcType = JdbcType.VARCHAR),

    })
    public List<Product> selectProductList(Product product);

    @Select("SELECT * FROM pos_product")
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "product_sn", property = "productSn", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_name", property = "productName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_description", property = "productDescription", jdbcType = JdbcType.VARCHAR),
            @Result(column = "price", property = "price", jdbcType = JdbcType.DECIMAL),
            @Result(column = "product_category_id", property = "productCategoryId", jdbcType = JdbcType.BIGINT),
            @Result(column = "image_url", property = "imageUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "detail_url", property = "detailUrl", jdbcType = JdbcType.VARCHAR),

    })
    public List<Product> selectAllProductList();

    public int insertProduct(Product product);

    public int updateProduct(Product product);

    public int deleteProductById(Long productId);
}
