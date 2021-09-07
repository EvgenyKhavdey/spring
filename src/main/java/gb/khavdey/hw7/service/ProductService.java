package gb.khavdey.hw7.service;

import gb.khavdey.hw7.model.Person;
import gb.khavdey.hw7.model.Product;
import gb.khavdey.hw7.repository.PersonDao;
import gb.khavdey.hw7.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;
    private final PersonDao personDao;


    public List<Product> findAll() {
        return productDao.findAll();
    }

    public List<Product> findById(Integer id) {
        return productDao.findAllById(Collections.singleton(id));
    }

    public void saveProduct(Product product) {
        productDao.save
                (product);
    }

    public void delete(Integer id){
        productDao.deleteById(id);
    }

    public List<Product> findByPersonId(Integer id){
        List<Person> personList =  personDao.findAllById(Collections.singleton(id));
        List<Product> collect = new ArrayList<>();
        for (Person person: personList) {
            collect.addAll(person.getProducts());
        }
        return collect;
    }

    public List<Product> findByPersonName(String name){
        List<Person> personList =  personDao.findByName(name);
        List<Product> collect = new ArrayList<>();
        for (Person person: personList) {
            collect.addAll(person.getProducts());
        }
        return collect;
    }
}
