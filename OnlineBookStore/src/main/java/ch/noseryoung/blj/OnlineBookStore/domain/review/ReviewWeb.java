package ch.noseryoung.blj.OnlineBookStore.domain.review;

import ch.noseryoung.blj.OnlineBookStore.domain.review.Review;
import ch.noseryoung.blj.OnlineBookStore.domain.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bookstore/reviews")  // parent mapping: functions like prefix -- on browser
public class ReviewWeb {

    @Autowired
    private ReviewService service;

    @GetMapping //GET -- READ
    private ResponseEntity<List<Review>> allReviews() {
        return ResponseEntity.ok().body(service.getAllReviews());
    }

    @GetMapping(value = "/{reviewId}")
    public ResponseEntity<Review> oneReview(@PathVariable("reviewId") Integer id) {
        return ResponseEntity.ok().body(service.getOneReview(id));
    }

    @PostMapping //POST -- CREATE
    public ResponseEntity<Review> createReview(@Valid @RequestBody() Review review) { //@RequestBody = goes in the body (RequestMapping)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAReview(review));
    }

    /*@PutMapping(value = "/{reviewId}") //PUT -- UPDATE
    public ResponseEntity<Review> updateReview(@Valid @PathVariable("reviewId") Integer id){
        return ResponseEntity.; //not correct
    }*/

    @DeleteMapping(value = "/{reviewId}") //DELETE -- DELETE
    public void deleteReview(@Valid @PathVariable("reviewId") Integer id) {
        service.deleteAReview(id);
    }

    /**
     * exceptions
     */

    /* from exercises
     @ExceptionHandler(NoSuchElementException.class) //NoSuchElementException
    public ResponseEntity<String> handlerNoSuchThingException(NoSuchElementException nsee) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find specific id");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class) //NoSuchElementException
    public ResponseEntity<String> handlerNotValidxception(MethodArgumentNotValidException nsee) {
        return ResponseEntity.status(400).body(nsee.getFieldError().getDefaultMessage()); //only field which dont match with its requirement
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handlerNoSuchProductException(ProductNotFoundException nsee) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find specific id");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handlerNoSuchProductException(ProductNotFoundException nsee) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nsee.getMessage());
    }
     */
}
