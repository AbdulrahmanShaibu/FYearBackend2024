package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
