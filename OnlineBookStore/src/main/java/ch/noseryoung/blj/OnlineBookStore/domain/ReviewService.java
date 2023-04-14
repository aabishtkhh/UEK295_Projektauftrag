package ch.noseryoung.blj.OnlineBookStore.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired //enables you to inject the object dependency implicitly
    private ReviewRepository repository;

    public List<Review> getAllReviews(){
        return repository.findAll();
    }

    public Review getOneReview(Integer id){
        return repository.findById(id).orElseThrow(); //exceptions
    }

    public Review postAReview(Review review){
        return repository.save(review);
    }

    public Review updateAReview(Integer id){
        return repository.findById(id).orElseThrow();
    }

}
