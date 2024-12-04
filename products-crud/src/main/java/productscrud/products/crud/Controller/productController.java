package productscrud.products.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productscrud.products.crud.Entity.Product;
import productscrud.products.crud.Service.ProductService;
import productscrud.products.crud.dto.ProductDto;

import java.util.List;


@RestController
@RequestMapping("/")
public class productController {
    @Autowired
    private ProductService productService;// instantiation

    // inserting a product in the database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    //getting by its ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable("productId") long productId) {

        try {
            Product product = productService.getSingleProduct(productId);
           /* if (product == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }*/
            return new ResponseEntity<>(product, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Product doest not exist", HttpStatus.NOT_FOUND);
        }
    }

    // getting all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // updating the products
    @PatchMapping("/product/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable("productId") long productId, @RequestBody ProductDto product) {
        try {
            Product updatedProduct = productService.updateProduct(productId, product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Product doesnt exist", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity<?> deleteProduct(@RequestParam(name = "productId") long productId) {
        try {
            productService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Product does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/productsbyname")
    public List<Product> getProductByName(@PathVariable(name = "productName") String productName) {
        return productService.getProductByName(productName);
    }


}
