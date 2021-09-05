package gb.khavdey.hw6.repository;

import gb.khavdey.hw6.model.Person;
import gb.khavdey.hw6.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
public class PersonDao {

    private static List personDb;
    private static SessionFactory factory;

    public PersonDao() {
        this.personDb = new CopyOnWriteArrayList<Product>();
        factory = new Configuration()
                .configure("configs/model/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public List<Product> findAll() {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            personDb.addAll(session.createQuery("from Person ").getResultList());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Product> collect = (List<Product>) personDb.stream().collect(Collectors.toUnmodifiableList());
        personDb.clear();
        return collect;
    }
    public List<Product> findById(Long id) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            personDb.add(session.get(Person.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Product> collect = (List<Product>) personDb.stream().collect(Collectors.toUnmodifiableList());
        personDb.clear();
        return collect;
    }

    public void savePerson(Person person) {

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
