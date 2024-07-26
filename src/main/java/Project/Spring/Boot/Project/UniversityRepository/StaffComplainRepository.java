package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.StaffComplain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffComplainRepository extends JpaRepository<StaffComplain,Integer> {
    @Query("SELECT sc FROM StaffComplain sc JOIN FETCH sc.staffs WHERE sc.complainID = :id")
    Optional<StaffComplain> findByIdWithUser(@Param("id") int id);
}
