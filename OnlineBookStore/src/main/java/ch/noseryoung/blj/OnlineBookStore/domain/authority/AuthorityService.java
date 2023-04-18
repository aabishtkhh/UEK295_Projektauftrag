package ch.noseryoung.blj.OnlineBookStore.domain.authority;

import ch.noseryoung.blj.OnlineBookStore.domain.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository repository;

}
