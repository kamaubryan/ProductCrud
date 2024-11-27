package productscrud.products.crud.Controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    // here we are getting the location using the getmapping
    @GetMapping("/")
    public ResponseEntity<?> ebHealth(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/health")
    public ResponseEntity<?> health(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
