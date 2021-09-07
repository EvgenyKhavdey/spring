package gb.khavdey.hw7.repository;


import gb.khavdey.hw7.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

    List<Person> findByName(String name);
}
