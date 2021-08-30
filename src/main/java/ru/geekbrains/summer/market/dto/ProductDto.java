package ru.geekbrains.summer.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.summer.market.model.ProductEntity;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private String categoryTitle;
    private BigDecimal price;


    public ProductDto(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.title = productEntity.getTitle();
        this.categoryTitle = productEntity.getCategoryEntity().getTitle();
        this.price = productEntity.getPrice();

//    public ProductDto(Product product) {
//        this.id = product.getId();
//        this.title = product.getTitle();
//        this.categoryTitle = product.getCategory().getTitle();
//        this.price = product.getPrice();
    }
}
