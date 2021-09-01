package gb.khavdey.hw5.service;

import gb.khavdey.hw5.model.Product;
import gb.khavdey.hw5.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;


    public List<Product> findAll() {
        return productDao.findAll();
    }

    public List<Product> findById(Long id) {
        return productDao.findById(id);
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public void delete(Long id){
        productDao.delete(id);
    }
}
