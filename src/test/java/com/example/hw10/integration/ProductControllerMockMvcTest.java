package com.example.hw10.integration;

import com.example.hw10.dao.ProductDto;
import com.example.hw10.model.Product;
import com.example.hw10.repository.ProductDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerMockMvcTest {

    private static final String BASE_URL = "/app/v1/product";

    @Autowired
    private ProductDao productDao;

    @Autowired
    private MockMvc mvc;

    @Test
    public void findAllSuccess() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"title\":\"Хлеб Бородинский\",\"cost\":51},{\"id\":2,\"title\":\"Хлеб Ржаной\",\"cost\":42},{\"id\":3,\"title\":\"Мясо Птицы\",\"cost\":236},{\"id\":4,\"title\":\"Мясо Говядина\",\"cost\":412},{\"id\":5,\"title\":\"Рыба\",\"cost\":892},{\"id\":6,\"title\":\"Сыр\",\"cost\":167},{\"id\":7,\"title\":\"Молоко\",\"cost\":72}]", true));
    }

    @Test
    public void saveProductSuccess() throws Exception {
       Product product = new Product(null, "Курица", 200);
       productDao.save(product);
        mvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"title\":\"Хлеб Бородинский\",\"cost\":51},{\"id\":2,\"title\":\"Хлеб Ржаной\",\"cost\":42},{\"id\":3,\"title\":\"Мясо Птицы\",\"cost\":236},{\"id\":4,\"title\":\"Мясо Говядина\",\"cost\":412},{\"id\":5,\"title\":\"Рыба\",\"cost\":892},{\"id\":6,\"title\":\"Сыр\",\"cost\":167},{\"id\":7,\"title\":\"Молоко\",\"cost\":72},{\"id\":8,\"title\":\"Курица\",\"cost\":200}]", true));

    }

    @Test
    public void deleteByIdSuccess() throws Exception {
        Integer id = 3;
        productDao.deleteById(id);
        mvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"title\":\"Хлеб Бородинский\",\"cost\":51},{\"id\":2,\"title\":\"Хлеб Ржаной\",\"cost\":42},{\"id\":4,\"title\":\"Мясо Говядина\",\"cost\":412},{\"id\":5,\"title\":\"Рыба\",\"cost\":892},{\"id\":6,\"title\":\"Сыр\",\"cost\":167},{\"id\":7,\"title\":\"Молоко\",\"cost\":72}]", true));

    }

}
