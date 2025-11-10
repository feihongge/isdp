package edu.scau.mis_pos.service;

import edu.scau.mis.common.annotation.Lowercase;
import edu.scau.mis_pos.domain.Product;

import java.util.List;
@Lowercase
public interface IProductService {

    List<Product> PRODUCTS = List.of();

    Product getProductById(Long productId);

    Product getProductBySn(String productSn);

    List<Product> getAllProducts();


    List<Product> getProducts(Product product);

    int addProduct(Product product);

    int updateProduct(Product product);

    int deleteProduct(Long productId);
}
