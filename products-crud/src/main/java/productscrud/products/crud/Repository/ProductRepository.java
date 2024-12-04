package productscrud.products.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productscrud.products.crud.Entity.Product;// we have imported the class since to use the properties

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findProductByProductName(String productName);

    @Override
    Optional<Product> findById(Long id);

  Optional <Product> findProductByName(String Name);

}
