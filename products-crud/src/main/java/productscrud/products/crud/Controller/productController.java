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
   private ProductService productService;// instantiation
// inserting a product in the database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct =productService.saveProduct( product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    //getting by its ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<?>getProduct(@PathVariable("productId") long productId){

        try {
            Product product = productService.getSingleProduct(productId);
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        } catch (Exception e) {

            return new ResponseEntity<>("Product doest not exist",HttpStatus.NOT_FOUND);
        }
    }
    // getting all products
    @GetMapping("/products")
public ResponseEntity<List<Product>> getProducts(){
   List<Product> products = productService.getProducts();
   return new ResponseEntity<>(products, HttpStatus.OK);
    }
    // updating the products
    @PatchMapping("/product/{ProductId}")
    public ResponseEntity<?>updateProduct(@PathVariable("productId") long productId, @RequestBody Product product){
     try {
         Product updatedProduct= productService.updateProduct(productId, product);
         return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
     }
     catch (Exception e){
         return new ResponseEntity<>("Product doesnt exist", HttpStatus.NOT_FOUND);
     }
    }

    @DeleteMapping("/product/{Id}")
    public ResponseEntity<?> deleteProduct(@RequestParam(name = "deletedProduct")long productId){
      try {
          Product deletedProduct = productService.deleteProduct(productId);
          return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
      }
      catch (Exception e){
          return new ResponseEntity<>("Product does not exist",HttpStatus.NOT_FOUND);
      }
    }
    @GetMapping("/product/productsbyname")
    public List<Product> getProductByName(@PathVariable(name = "productName") String productName){
        return productService.getProductByName(productName);
    }


}
