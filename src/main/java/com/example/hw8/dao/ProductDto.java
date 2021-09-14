package com.example.hw8.dao;

import com.example.hw8.model.Product;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String title;
    private Integer cost;

    public static ProductDto valueOf(Product product) {
        return new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getCost()
        );
    }

    public Product mapToProduct() {
        Product product = new Product();
        product.setId(id);
        product.setCost(cost);
        product.setTitle(title);
        return product;
    }
}
