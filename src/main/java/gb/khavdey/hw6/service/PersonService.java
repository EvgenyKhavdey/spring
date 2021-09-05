package gb.khavdey.hw6.service;

import gb.khavdey.hw6.model.Person;
import gb.khavdey.hw6.model.Product;
import gb.khavdey.hw6.repository.PersonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonDao personDao;


    public List<Product> findAll() {
        return personDao.findAll();
    }

    public List<Product> findById(Long id) {
        return personDao.findById(id);
    }

    public void savePerson(Person person) {
        personDao.savePerson(person);
    }

}
