package gb.spring.lesson4.repository;

import gb.spring.lesson4.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private Map<Integer, Product> productDb;

    public ProductRepository() {
        this.productDb = new ConcurrentHashMap<>();
        productDb.put(1, new Product(1, "Хлеб", 27));
        productDb.put(2, new Product(2, "Мясо", 412));
        productDb.put(3, new Product(3, "Рыба", 892));
        productDb.put(4, new Product(4, "Сыр", 167));
        productDb.put(5, new Product(5, "Молоко", 72));
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>(productDb.values());
        return  list;
    }

    public Optional<Product> findById(Integer id) {
        return productDb.values().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(productDb.size() + 1);
        }
        productDb.put(product.getId(), product);
    }

    public void delete(Integer id){
        productDb.remove(id);
    }
}
