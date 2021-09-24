package com.example.hw10.dao;

import com.example.hw10.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String title;
    private Integer cost;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.cost = p.getCost();
    }

}
