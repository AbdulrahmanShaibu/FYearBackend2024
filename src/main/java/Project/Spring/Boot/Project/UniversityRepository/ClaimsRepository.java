package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.Claims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsRepository extends JpaRepository<Claims,Integer> {
}
