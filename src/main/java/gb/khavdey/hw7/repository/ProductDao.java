package gb.khavdey.hw7.repository;

import gb.khavdey.hw7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

}
