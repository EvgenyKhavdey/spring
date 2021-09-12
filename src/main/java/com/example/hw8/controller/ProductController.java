package com.example.hw8.controller;

import com.example.hw8.dao.ProductDto;
import com.example.hw8.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }


    @PostMapping
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        productService.delete(id);
    }


    @PostMapping("/name")
    public List<ProductDto> search(@RequestBody String text) {
        return productService.searchProduct(text);
    }

    @GetMapping("/sort")
    public List<ProductDto> findAllSort() {
        return productService.findAllSort();
    }

}
