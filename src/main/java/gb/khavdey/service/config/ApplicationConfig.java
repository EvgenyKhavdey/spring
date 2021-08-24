package gb.khavdey.service.config;

import gb.khavdey.service.impl.Cart;
import gb.khavdey.service.impl.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
@ComponentScan(basePackages = "gb.khavdey")
public class ApplicationConfig {

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository(new ArrayList<>());
    }

//    @Bean
//    public Cart cart(){
//        return new Cart(new ArrayList<>(), new ProductRepository(new ArrayList<>()));
//    }

}
