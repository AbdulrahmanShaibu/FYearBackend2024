package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleanerRepository extends JpaRepository<Cleaner,Integer> {
    //Add Custom queries if any
}
