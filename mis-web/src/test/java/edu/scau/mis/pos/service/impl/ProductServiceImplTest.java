package edu.scau.mis.pos.service.impl;

import edu.scau.mis_pos.domain.Product;
import edu.scau.mis_pos.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private IProductService productService;


    @Test
    void getProductById() {
        Product product = productService.getProductById(1L);
        System.out.println(product);
    }

    @Test
    void getProductBySn() {
        Product product = productService.getProductBySn("1002");
        System.out.println(product);
        assertEquals(3L,product.getProductId(), "测试不通过");
    }

    @org.junit.jupiter.api.Test
    void getAllProducts() {
    }

    @org.junit.jupiter.api.Test
    void getProducts() {
    }

    @org.junit.jupiter.api.Test
    void addProduct() {
    }

    @org.junit.jupiter.api.Test
    void updateProduct() {
    }

    @org.junit.jupiter.api.Test
    void deleteProduct() {
    }
}