package gb.khavdey.hw5.repository;

import gb.khavdey.hw5.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
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
        List<Product> collect = (List<Product>) productDb.stream().collect(Collectors.toUnmodifiableList());
        productDb.clear();
        return collect;
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
        List<Product> collect = (List<Product>) productDb.stream().collect(Collectors.toUnmodifiableList());
        productDb.clear();
        return collect;
    }

    public void save(Product product) {

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.merge(new Product(null,product.getTitle(), product.getCost()));
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
}
