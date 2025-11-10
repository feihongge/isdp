package edu.scau.mis_pos.mapper;

import edu.scau.mis_pos.domain.Category;
import edu.scau.mis_pos.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
@Primary
public class ProductCatalog implements ICategoryMapper ,IProductMapper{

public static final ConcurrentHashMap<String, Product> PRODUCT_CACHE = new ConcurrentHashMap<>();

public static final ConcurrentHashMap<Long, Category> CATEGORY_CACHE = new ConcurrentHashMap<>();

 static {
     Category category1 = new Category(1L,0L,"文具-内存");
     Category category2 = new Category(2L,0L,"日用品");
     Category category3 = new Category(3L,0L,"手机");
     CATEGORY_CACHE.put(category1.getCategoryId(), category1);
     CATEGORY_CACHE.put(category2.getCategoryId(), category2);
     CATEGORY_CACHE.put(category3.getCategoryId(), category3);

     Product[] products = new Product[10];
     products[0] = new Product(1L,"1001","钢笔-内存","",new BigDecimal("65.00"), 1L,category1,null, null);
     products[1] = new Product(2L,"1002","日记本","",new BigDecimal("20.00"),1L,category1,null,null);
     products[2] = new Product(3L,"1003","铅笔盒","",new BigDecimal("45.00"),1L,category1,null,null);
     products[3] = new Product(4L,"1004","毛巾","",new BigDecimal("10.00"),2L,category2,null,null);
     products[4] = new Product(5L,"1005","香波","",new BigDecimal("80.00"),2L,category2,null,null);
     products[5] = new Product(6L,"1006","拖鞋", "",new BigDecimal("30.00"),2L, category2,null,null);
     products[6] = new Product(7L,"1007","Mate X5", "超轻薄四曲折叠，超高分辨率临境双屏",new BigDecimal("13499.00"),3L, category3,
             "https://res6.vmallres.com/pimages//uomcdn/CN/pms/202309/gbom/6942103107320/800_800_959526DD397D0C873FCE80CE67C9A0BFmp.png",
             "https://www.vmall.com/product/comdetail/index.html?prdId=10086281788718&sbomCode=2601010457506");
     products[7] = new Product(8L,"1008","Pura 70 Pro", "超聚光微距长焦，超高速风驰闪拍",new BigDecimal("6499.00"),3L, category3,
             "https://res2.vmallres.com/pimages//uomcdn/CN/pms/202404/gbom/6942103119071/800_800_AE94E48F4A6370D6E956B4E722588A5Amp.png",
             "https://www.vmall.com/product/comdetail/index.html?prdId=10086821546239&sbomCode=2601010486504");
     products[8] = new Product(9L,"1009","Mate 60", "超可靠玄武架构，全焦段超清影像",new BigDecimal("5499.00"),3L, category3,
             "https://res8.vmallres.com/pimages//uomcdn/CN/pms/202403/gbom/6942103107719/800_800_5818B6A12914274ED24FB8FE47F1CD34mp.png",
             "https://www.vmall.com/product/comdetail/index.html?prdId=10086970184614&sbomCode=2601010453707");
     products[9] = new Product(10L,"1010","Pura 70", "超高速风驰闪拍，第二代昆仑玻璃",new BigDecimal("8499.00"),3L, category3,
             "https://res4.vmallres.com/pimages//uomcdn/CN/pms/202404/gbom/6942103120374/800_800_606AD050130CDD9F17DBBB7EECDD9B4Amp.png",
             "https://www.vmall.com/product/comdetail/index.html?prdId=10086157311748&sbomCode=2601010486608");
     for (int i = 0; i < products.length; i++) {
         PRODUCT_CACHE.put(products[i].getProductSn(), products[i]);
     }
 }








    @Override
    public Category selectCategoryById(Long categoryId) {
        return CATEGORY_CACHE.get(categoryId);
    }

    @Override
    public List<Category> selectAllCategoryList() {
       List<Category> categoryList = new ArrayList<>(CATEGORY_CACHE.values());
       return categoryList;
    }

    @Override
    public List<Category> selectCategoryList(Category query) {

     return CATEGORY_CACHE.values().stream()
             .filter(category -> category.getCategoryId() == null
                     || category.getCategoryId().equals(query.getCategoryId()))
             .filter(category -> category.getParentId() == null
                     || category.getParentId().equals(query.getParentId()))
             .filter(category -> category.getCategoryname() == null
                     || category.getCategoryname().trim().isEmpty()
                     ||  category.getCategoryname().equals(query.getCategoryname()))
             .collect(Collectors.toList());

    }

    @Override
    public int insertCategory(Category category) {
        long newId = CATEGORY_CACHE.keySet().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0L) + 1;

        category.setCategoryId(newId);
        CATEGORY_CACHE.put(newId, category);
        return 1;
    }

    @Override
    public int updateCategory(Category category) {
        Category existing = CATEGORY_CACHE.get(category.getCategoryId());
        existing.setParentId(category.getParentId());
        existing.setCategoryname(category.getCategoryname());
        return 1;
    }

    @Override
    public int deleteCategoryById(Long id) {
        if (id == null || !CATEGORY_CACHE.containsKey(id)) {
            return 0; // ID不存在
        }
        CATEGORY_CACHE.remove(id);
        return 1;
    }

    @Override
    public Product selectProductById(Long productId) {
     return PRODUCT_CACHE.values().stream()
             .filter(product -> product.getProductId().equals(productId))
             .findFirst()
             .orElse(null);

    }

    @Override
    public Product selectProductBySn(String productSn) {
        return PRODUCT_CACHE.get(productSn);
    }

    @Override
    public List<Product> selectProductList(Product product) {

        return PRODUCT_CACHE.values().stream()
                .filter(p -> product.getProductSn() == null ||
                        product.getProductSn().trim().isEmpty() ||
                        (p.getProductSn() != null && p.getProductSn().equals(product.getProductSn())))
                .filter(p -> product.getProductName() == null ||
                        product.getProductName().trim().isEmpty() ||
                        (p.getProductName() != null && p.getProductName().toLowerCase()
                                .contains(product.getProductName().toLowerCase().trim())))
                .filter(p -> product.getProductCategoryId() == null ||
                        Objects.equals(p.getProductCategoryId(), product.getProductCategoryId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> selectAllProductList() {

       return  PRODUCT_CACHE.values().stream()
               .collect(Collectors.toList());
    }

    @Override
    public int insertProduct(Product product) {

        product.setProductId((long) (PRODUCT_CACHE.size()+1));
        product.setCategory(CATEGORY_CACHE.get(product.getProductCategoryId()));
        PRODUCT_CACHE.put(product.getProductSn(), product);
        return 1;
    }

    @Override
    public int updateProduct(Product product) {
        product.setCategory(CATEGORY_CACHE.get(product.getProductCategoryId()));
        PRODUCT_CACHE.put(product.getProductSn(), product);
        return 1;
    }

    @Override
    public int deleteProductById(Long productId) {
       return PRODUCT_CACHE.values().stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .map(product ->{ PRODUCT_CACHE.remove(product.getProductSn());
                                           return 1 ;})
                .orElse(0);


    }
}
