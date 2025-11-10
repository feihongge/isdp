package edu.scau.mis_pos.domain;

import edu.scau.mis.common.annotation.Lowercase;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
@Lowercase
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    private Long productId;
    private String productSn;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private Long productCategoryId;
    private Category category;
    private String imageUrl;
    private String detailUrl;




}
