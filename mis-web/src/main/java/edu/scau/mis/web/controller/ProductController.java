package edu.scau.mis.web.controller;

import edu.scau.mis_pos.domain.Product;
import edu.scau.mis_pos.service.IProductService;
import edu.scau.mis.common.web.domain.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "商品管理")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Operation(summary = "根据ID查询商品111")
    @GetMapping("/{productId}")
    @ApiResponse(responseCode = "200", description = "查询成功", content = @Content(schema = @Schema(implementation = Product.class)))
    public ApiResult<Product> getById(
            @Parameter(description = "商品ID",in = ParameterIn.PATH, required = true)
            @PathVariable("productId") Long productId){
        Product product = productService.getProductById(productId);
      //  HttpStatus status = product == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return product == null ? ApiResult.noContent() : ApiResult.success(product);
    }
    @GetMapping("/getBySn/{productSn}")
    public ApiResult<Product> getBySn(@PathVariable("productSn") String productSn){
       Product product = productService.getProductBySn(productSn);
       return product == null ? ApiResult.noContent() : ApiResult.success(product);
    }


    @GetMapping("/listAll")
    public ApiResult<List<Product>> listAll(){
       List<Product> products = productService.getAllProducts();
        return products.isEmpty() ? ApiResult.noContent() : ApiResult.success(products);
    }

    @GetMapping("/listByParams")
    public ApiResult<List<Product>> listByParams(Product product){
        List<Product> products = productService.getProducts(product);
        return products.isEmpty() ? ApiResult.noContent() : ApiResult.success(products);
    }

    @PostMapping("/add")
    public int add(@RequestBody Product  product){
        return productService.addProduct(product);
    }

    @PutMapping("/update")
    public int update(@RequestBody Product product){
        return productService.updateProduct(product);

    }

    @DeleteMapping("/{productId}")
    public int delete(@PathVariable("productId") Long productId){
        return productService.deleteProduct(productId);
    }


}
