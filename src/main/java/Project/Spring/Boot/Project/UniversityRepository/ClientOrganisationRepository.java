package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.ClientOrganisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientOrganisationRepository extends JpaRepository<ClientOrganisation,Integer> {
    Optional<ClientOrganisation> findByName(String name);
}
