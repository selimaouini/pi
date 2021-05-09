package tn.esprit.spring.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.User.User;
import tn.esprit.spring.entities.User.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>{

    VerificationToken findByToken(String token);
 
    VerificationToken findByUser(User user);

}
