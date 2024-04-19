package Project.Spring.Boot.Project.Repository;

import Project.Spring.Boot.Project.Controller.AuthenticattionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticattionRepo extends JpaRepository<AuthenticattionRequest,Integer> {
}
