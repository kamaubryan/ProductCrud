package productscrud.products.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productscrud.products.crud.Entity.Product;// we have imported the class since to use the properties

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByProductName(String productName);
    List<Product> findProductByName(String Name);

}
