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
public class ProductDao {
    private static List productDb;
    private static SessionFactory factory;

    public ProductDao() {
        this.productDb = new CopyOnWriteArrayList<Product>();
        factory = new Configuration()
                .configure("configs/model/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public List<Product> findAll() {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            productDb.addAll(session.createQuery("from Product ").getResultList());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return methodList();
    }
    public List<Product> findById(Long id) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            productDb.add(session.createNamedQuery("byIdSelect", Product.class)
                    .setParameter("id", id).getSingleResult());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return methodList();
    }

    public void saveProduct(Product product) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(session.get(Product.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> findByPersonId(Long id){
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            productDb.addAll(person.getProducts());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return methodList();
    }
    public List<Product> findByPersonName(String name){
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Person person = (Person) session.createNamedQuery("byNameSelect", Person.class)
                    .setParameter("name", name).getSingleResult();
            productDb.addAll(person.getProducts());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return methodList();
    }

    private List<Product> methodList(){
        List<Product> collect = (List<Product>) productDb.stream().collect(Collectors.toUnmodifiableList());
        productDb.clear();
        return collect;
    }
}
