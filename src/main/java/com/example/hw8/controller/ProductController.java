package com.example.hw8.controller;

import com.example.hw8.dao.ProductDto;
import com.example.hw8.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("app/v1/product")
@Api(value = "Products", produces = "Контроллер для продуктов")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    @ApiOperation("Получение всех продуктов")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }


    @PostMapping
    @ApiOperation("Сохранение нового продукта")
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаление продукта по id")
    public void deleteById(@PathVariable Integer id) {
        productService.delete(id);
    }


    @PostMapping("/name")
    @ApiOperation("Поиск продукта по имени")
    public List<ProductDto> search(@RequestBody String text) {
        return productService.searchProduct(text);
    }

    @GetMapping("/sort")
    @ApiOperation("Сортировка всех продуктов в алфовитном порядке")
    public List<ProductDto> findAllSort() {
        return productService.findAllSort();
    }

}
