package gb.khavdey.hw7.service;


import gb.khavdey.hw7.model.Person;
import gb.khavdey.hw7.model.Product;
import gb.khavdey.hw7.repository.PersonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonDao personDao;


    public List<Person> findAll() {
        return personDao.findAll();
    }

    public List<Person> findById(Integer id) {
        return personDao.findAllById(Collections.singleton(id));
    }

    public void savePerson(Person person) {
        personDao.save(person);
    }

}
