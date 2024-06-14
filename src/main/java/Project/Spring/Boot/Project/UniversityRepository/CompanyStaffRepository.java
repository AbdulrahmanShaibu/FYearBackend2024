package Project.Spring.Boot.Project.UniversityRepository;

import Project.Spring.Boot.Project.University.Models.CompanyStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyStaffRepository extends JpaRepository<CompanyStaff,Long> {
//    List<CompanyStaff>findByRole(StaffRoles staffRoles);
}
