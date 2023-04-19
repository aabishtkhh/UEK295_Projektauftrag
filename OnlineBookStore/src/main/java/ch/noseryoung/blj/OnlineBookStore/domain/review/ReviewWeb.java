package ch.noseryoung.blj.OnlineBookStore.domain.review;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@Log4j2 //class that should use logging
@RequestMapping("/bookstore/reviews")  // parent mapping: functions like prefix -- on browser
public class ReviewWeb {

    @Autowired
    private ReviewService service;

    @GetMapping //GET -- READ
    @PreAuthorize("hasAuthority('GET')") //connecting to authority
    @Operation(summary = "Fetches all Reviews", description = "When successful it fetches all reviews and returns a JSON-Code with status code 200.")
    public ResponseEntity<List<Review>> allReviews() {
        return ResponseEntity.ok().body(service.getAllReviews());
    }

    @GetMapping(value = "/{reviewId}") //has exception
    @PreAuthorize("hasAuthority('GET')") //connecting to authority
    @Operation(summary = "Fetches the desired Review", description = "When successful it fetches the wished review and returns the JSON-Code with status code 200.")
    public ResponseEntity<Review> oneReview(@PathVariable("reviewId") Integer id) throws ReviewException {
        return ResponseEntity.ok().body(service.getOneReview(id));
    }

    @PostMapping //POST -- CREATE
    @PreAuthorize("hasAuthority('POST')") //connecting to authority
    @Operation(summary = "Creates a Review", description = "When successful it creates a review with the wished values and returns the JSON-Code of created review with status code 200.")
    public ResponseEntity<Review> createReview(@Valid @RequestBody() Review review) { //@RequestBody = goes in the body (RequestMapping)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAReview(review));
    }

    @PutMapping(value = "/{reviewId}") //PUT -- UPDATE
    @PreAuthorize("hasAuthority('PUT')") //connecting to authority
    @Operation(summary = "Updates the wished Review", description = "When successful it updates the review with the wished values and returns the JSON-Code of the updated review with status code 200.")
    public void updateReview(@Valid @PathVariable("reviewId") Review review){
        service.putAReview(review);
    }

    @DeleteMapping(value = "/{reviewId}") //DELETE -- DELETE
    @PreAuthorize("hasAuthority('DELETE')") //connecting to authority
    @Operation(summary = "Deletes the Review", description = "When successful it deletes the review with status code 200.")
    public void deleteReview(@Valid @PathVariable("reviewId") Integer id) {
        service.deleteAReview(id);
    }

    /**
     * exceptions
     */

    @ExceptionHandler(ReviewException.class) //When ID doesn't exist
    public ResponseEntity<String> handlerNoSuchReviewException(ReviewException re) {
        log.error("ID not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage()); //message in service
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //Not Null
    public ResponseEntity<String> handlerNoNullReviewException(MethodArgumentNotValidException manve) {
        log.warn("Fill everything out");
        return ResponseEntity.status(400).body(Objects.requireNonNull(manve.getFieldError()).getDefaultMessage());
    }
}
