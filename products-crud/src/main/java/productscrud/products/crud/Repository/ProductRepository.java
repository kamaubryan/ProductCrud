package productscrud.products.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productscrud.products.crud.Entity.Product;// we have imported the class since to use the properties

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {///  when we extend the jpa repo it implements the built methods
    // we have to create a list of getting a method by name
List<Product> getProductByProductName(String productName);
    List<Product> getProductByName(String productName);

}
