package ch.noseryoung.blj.OnlineBookStore.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> { //field class, id dtyp
    Optional<Users> findByUsrName(String usrName);

}
