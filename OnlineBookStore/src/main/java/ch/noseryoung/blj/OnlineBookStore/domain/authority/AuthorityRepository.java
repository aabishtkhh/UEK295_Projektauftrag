package ch.noseryoung.blj.OnlineBookStore.domain.authority;

import ch.noseryoung.blj.OnlineBookStore.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}