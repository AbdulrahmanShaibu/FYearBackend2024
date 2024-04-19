package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor,Long> {
}
