package productscrud.products.crud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productscrud.products.crud.Entity.Product;
import productscrud.products.crud.Repository.ProductRepository;
import productscrud.products.crud.dto.ProductDto;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
@Autowired// helps not to instantiate the class
    ProductRepository productRepository;// here we have used the autowired where we have obtained all the methods from the product repo

    public Product saveProduct(Product product){
        return productRepository.save(product);// we have to use the new instantiated product
    }

    public Product getSingleProduct(long productId){
        return productRepository.findById(productId).orElseThrow(()->new RuntimeException("Not found"));// here we have used a trycatch error where if its not found it give an error called not found
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(long productId, ProductDto product){// this method accepts two parameters
        Product existingProduct = productRepository.findById(productId).orElseThrow(()->new RuntimeException("Not Found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    public void deleteProduct(long productId){
        Product existingProduct = productRepository.findById(productId).orElseThrow(()->new RuntimeException("Not Found"));
        productRepository.deleteById(productId);

    }
    public Optional<Product> getProductByName(String productname){
        return productRepository.findProductByProductName(productname);
    }

    public Product getProductById (long productId){
        return  productRepository.findById(productId).orElseThrow(()->new RuntimeException("not Found"));
    }




}
