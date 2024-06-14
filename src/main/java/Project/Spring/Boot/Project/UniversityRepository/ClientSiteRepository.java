package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.ClientSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientSiteRepository extends JpaRepository<ClientSite, Long> {
    // You can add custom query methods here if needed
}
