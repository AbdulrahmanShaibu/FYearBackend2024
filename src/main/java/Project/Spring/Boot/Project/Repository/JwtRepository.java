package Project.Spring.Boot.Project.Repository;

import Project.Spring.Boot.Project.Model.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JwtRepository extends JpaRepository<JwtUser, Integer> {
    JwtUser findByEmail(String email);
//    Optional<JwtUser> findByEmail(String email);

    // or for multiple users with the same email
    List<JwtUser> findAllByEmail(String email);

}
