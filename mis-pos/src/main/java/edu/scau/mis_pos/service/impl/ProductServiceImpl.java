package edu.scau.mis_pos.service.impl;

import edu.scau.mis_pos.domain.Product;
import edu.scau.mis_pos.mapper.IProductMapper;
import edu.scau.mis_pos.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    @Qualifier("IProductMapper")
    @Autowired
    private IProductMapper productMapper;

    @Override
    public Product getProductById(Long productId) {
        Product product = productMapper.selectProductById(productId);
        log.debug("查询成功: {}" , product);
        return product;
    }

    @Override
    public Product getProductBySn(String productSn) {
        return productMapper.selectProductBySn(productSn);
    }

    @Override
    public List<Product> getAllProducts() {

        return productMapper.selectAllProductList();
    }

    @Override
    public List<Product> getProducts(Product product) {
        return productMapper.selectProductList(product);
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public int deleteProduct(Long productId) {
        return productMapper.deleteProductById(productId);
    }
}
