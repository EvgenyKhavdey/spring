package gb.khavdey.hw6.service;


import gb.khavdey.hw6.model.Product;
import gb.khavdey.hw6.repository.ProductDao;
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

    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    public void delete(Long id){
        productDao.delete(id);
    }

    public List<Product> findByPersonId(Long id){
        return productDao.findByPersonId(id);
    }

    public List<Product> findByPersonName(String name){
        return productDao.findByPersonName(name);
    }
}
