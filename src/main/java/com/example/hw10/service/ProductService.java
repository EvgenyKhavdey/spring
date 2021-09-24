package com.example.hw10.service;

import com.example.hw10.dao.ProductDto;
import com.example.hw10.model.Product;
import com.example.hw10.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductDao productDao;

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        return productDao.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }


    public Product saveProduct(Product product) {
       return productDao.save(product);
    }

    public void delete(Integer id){
        productDao.deleteById(id);
    }
    public Optional<Product> findProductById(Integer id) {
        return productDao.findById(id);
    }

}
