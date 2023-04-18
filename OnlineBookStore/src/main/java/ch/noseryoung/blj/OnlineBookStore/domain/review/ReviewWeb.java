package ch.noseryoung.blj.OnlineBookStore.domain.review;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Log4j2 //class that should use logging
@RestController
@RequestMapping("/bookstore/reviews")  // parent mapping: functions like prefix -- on browser
public class ReviewWeb {

    @Autowired
    private ReviewService service;

    @GetMapping //GET -- READ
    private ResponseEntity<List<Review>> allReviews() {
        return ResponseEntity.ok().body(service.getAllReviews());
    }

    @GetMapping(value = "/{reviewId}") //has exception
    public ResponseEntity<Review> oneReview(@PathVariable("reviewId") Integer id) throws ReviewException {
        return ResponseEntity.ok().body(service.getOneReview(id));
    }

    @PostMapping //POST -- CREATE
    public ResponseEntity<Review> createReview(@Valid @RequestBody() Review review) { //@RequestBody = goes in the body (RequestMapping)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAReview(review));
    }

    @PutMapping(value = "/{reviewId}") //PUT -- UPDATE
    public void updateReview(@Valid @PathVariable("reviewId") Review review){
        service.putAReview(review);
    }

    @DeleteMapping(value = "/{reviewId}") //DELETE -- DELETE
    public void deleteReview(@Valid @PathVariable("reviewId") Integer id) {
        service.deleteAReview(id);
    }

    /**
     * exceptions
     */

    @ExceptionHandler(MethodArgumentNotValidException.class) //When method isn't valid -> stars not under 5, ..
    public ResponseEntity<String> handlerNotValidException(MethodArgumentNotValidException manve) {
        return ResponseEntity.status(400).body(manve.getFieldError().getDefaultMessage()); //only field which doesn't match with its requirement
    }

    @ExceptionHandler(ReviewException.class) //When ID doesn't exist
    public ResponseEntity<String> handlerNoSuchReviewException(ReviewException re) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage()); //message in service
    }

    @ExceptionHandler(ReviewException.class) //Not Null
    public ResponseEntity<String> handlerNoNullReviewException(MethodArgumentNotValidException manve) {
        return ResponseEntity.status(400).body(Objects.requireNonNull(manve.getFieldError()).getDefaultMessage());
    }

}
