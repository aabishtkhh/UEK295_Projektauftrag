package ch.noseryoung.blj.OnlineBookStore.domain.review;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Log4j2
public class ReviewService {
    @Autowired //enables you to inject the object dependency implicitly
    private ReviewRepository repository;

    public List<Review> getAllReviews() {
        log.info("All reviews shown");
        return repository.findAll();
    }

    public Review getOneReview(Integer id) throws ReviewException {
        log.info(id + " review found");
        return repository.findById(id).orElseThrow(() -> new ReviewException("ID not found")); //exceptions
    }

    public Review postAReview(Review review) {
        log.info(review + " created");
        return repository.save(review);
    }

    public void putAReview(Review review) {
        log.info(review + " review has been updated");
        repository
                .findById(review.getId()) // returns Optional<Review>
                .ifPresent(oldReview -> {
                    oldReview.setId(review.getId());
                    oldReview.setAutorIn(review.getAutorIn());
                    oldReview.setStars(review.getStars()); //needs void
                    oldReview.setBookId(review.getBookId());
                    repository.save(oldReview);
                });
    }

    public void deleteAReview(Integer id) {
        log.info(id + " review deleted");
        repository.deleteById(id); //deleteById must be in a void method
    }
}
