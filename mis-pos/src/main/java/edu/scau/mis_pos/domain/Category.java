package edu.scau.mis_pos.domain;

import edu.scau.mis.common.annotation.Lowercase;
import lombok.*;
import org.springframework.stereotype.Service;

@Lowercase
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    private Long categoryId;
    private Long parentId;
    private String categoryname;



    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", parentId=" + parentId +
                ", categoryname='" + categoryname + '\'' +
                '}';
    }
}
