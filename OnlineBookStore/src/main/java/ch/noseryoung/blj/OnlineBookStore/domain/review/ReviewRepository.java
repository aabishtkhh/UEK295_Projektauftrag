package ch.noseryoung.blj.OnlineBookStore.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> { //field class, id dtyp

}
