package ch.noseryoung.blj.OnlineBookStore.domain.review;

import ch.noseryoung.blj.OnlineBookStore.domain.review.Review;
import ch.noseryoung.blj.OnlineBookStore.domain.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookstore/reviews")  // parent mapping: functions like prefix -- on browser
public class ReviewWeb {

    @Autowired
    private ReviewService service;

    @GetMapping //GET -- READ
    private ResponseEntity<List<Review>> allReviews(){
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
    public ResponseEntity<Review> updateReview(@Valid @PathVariable("reviewId") Review review){
        return ResponseEntity.; //not correct
    }*/

}
