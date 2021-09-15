package com.example.hw10.unit;

import com.example.hw10.dao.ProductDto;
import com.example.hw10.model.Product;
import com.example.hw10.repository.ProductDao;
import com.example.hw10.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes  = ProductService.class)
public class ProductServesTest {

    @Autowired
    private  ProductService productService;

    @MockBean
    private ProductDao productDao;

    @Test
    public void findAllSuccess(){
        Mockito.doReturn(Collections.emptyList()).when(productDao).findAll();
        List<ProductDto> actual = productService.findAll();
        Assertions.assertThat(actual).isEmpty();
    }

    @ParameterizedTest(name="{arguments}")
    @CsvSource({"Мясо Птицы","Хлеб Бородинский"})
    public void searchProductSuccess(String name){
        Product product = new Product();
        product.setTitle(name);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase());
        Mockito.doReturn(Collections.emptyList()).when(productDao).findAll();
        List<ProductDto> actual = productService.searchProduct(name);
        Assertions.assertThat(actual).isEmpty();
    }

    @Test
    public void findAllSortSuccess(){
        Mockito.doReturn(Collections.emptyList()).when(productDao).findAll(Sort.by("title"));
        List<ProductDto> actual = productService.findAllSort();
        Assertions.assertThat(actual).isEmpty();
    }

}
