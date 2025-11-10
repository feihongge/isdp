package edu.scau.mis.pos.mapper;

import edu.scau.mis.IsdpBootApplication;
import edu.scau.mis_pos.domain.Product;
import edu.scau.mis_pos.mapper.IProductMapper;
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
class IProductMapperTest {

    @Qualifier("IProductMapper")
    @Autowired
    private IProductMapper ProductMapper;

    @org.junit.jupiter.api.Test
    void selectProductById() {
        Product product = ProductMapper.selectProductById(1L);
        assertEquals("钢笔",product.getProductName());
    }

    @org.junit.jupiter.api.Test
    void selectProductBySn() {
    }

    @org.junit.jupiter.api.Test
    void selectProductList() {
    }

    @org.junit.jupiter.api.Test
    void selectAllProductList() {
        List<Product> productList = ProductMapper.selectAllProductList();
        assertEquals(10,productList.size());
    }

    @org.junit.jupiter.api.Test
    void insertProduct() {
    }

    @org.junit.jupiter.api.Test
    void updateProduct() {
    }

    @org.junit.jupiter.api.Test
    void deleteProductById() {
    }
}