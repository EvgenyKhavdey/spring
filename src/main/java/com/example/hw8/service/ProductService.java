package com.example.hw8.service;

import com.example.hw8.dao.ProductDto;
import com.example.hw8.model.Product;
import com.example.hw8.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductDao productDao;
    private final PersonDao personDao;


    public List<ProductDto> findAll() {
        return productDao.findAll().stream()
                .map(ProductDto::valueOf)
                .collect(Collectors.toList());
    }


    public void saveProduct(ProductDto productDto) {
        productDao.save(productDto.mapToProduct());
    }

    public void delete(Integer id){
        productDao.deleteById(id);
    }

    public List<ProductDto> searchProduct(String name) {
        Product product = new Product();
        product.setTitle(name);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase());
        List<Product> list = productDao.findAll(Example.of(product, matcher));
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product pr : list){
            dtoList.add(ProductDto.valueOf(pr));
        }
        return dtoList;

    }

}
