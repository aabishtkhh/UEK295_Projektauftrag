package ch.noseryoung.blj.OnlineBookStore.domain.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ReviewService {
    @Autowired //enables you to inject the object dependency implicitly
    private ReviewRepository repository;

    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    public Review getOneReview(Integer id) throws ReviewException {
        return repository.findById(id).orElseThrow(() -> new ReviewException("ID not found")); //exceptions
    }

    public Review postAReview(Review review) {
        return repository.save(review);
    }

    public void putAReview(Review review) {
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
        repository.deleteById(id); //deleteById must be in a void mehod
    }
}
