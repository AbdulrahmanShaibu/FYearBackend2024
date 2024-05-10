package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {
    //Custom Query, Optional
//    Staff getByStaffName(String StaffName);
}
