package productscrud.products.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productscrud.products.crud.Entity.Product;
import productscrud.products.crud.Service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/")
public class productController {
    @Autowired
    ProductService productService;// instantiation
// inserting a product in the database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct =productService.saveProduct( product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    //getting by its ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<?>getProduct(@PathVariable("productId") long productId){

        try {
            Product product = productService.getSingleProduct(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Product doest not exist",HttpStatus.NOT_FOUND);
        }
    }
    // getting all products
    @GetMapping("/products")
public List<Product>getProducts(){
        return productService.getProducts();
    }
    // updating the products
    @PatchMapping("/product/{ProductId}")
    public ResponseEntity<Product>updateProduct(@PathVariable("productId") long productId, @RequestBody Product product){
        Product updatedProduct= productService.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/product/{Id}")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "deletedProduct")long productId){
        Product deletedProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }
    @GetMapping("/products-by-name")
    public List<Product> getProductByName(@RequestParam(name = "productName") String productName){
        return productService.getProductByName(productName);
    }


}
