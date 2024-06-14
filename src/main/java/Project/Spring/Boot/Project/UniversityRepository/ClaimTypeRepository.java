package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.ClaimType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimTypeRepository extends JpaRepository<ClaimType, Long> {
}