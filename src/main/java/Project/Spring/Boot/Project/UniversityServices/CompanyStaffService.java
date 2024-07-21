package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.CompanyStaff;
import Project.Spring.Boot.Project.UniversityRepository.CompanyStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyStaffService {
    @Autowired
    private CompanyStaffRepository companyStaffRepository;

    public List<CompanyStaff> getAllCompanyStaffs() {
        return companyStaffRepository.findAll();
    }

    public CompanyStaff getCompanyStaffsById(Long id) {
        return companyStaffRepository.findById(id)
                .orElseThrow(() -> new
                        NoSuchElementException("CompanyStaff not found with id " + id));
    }

    public ResponseEntity<String> createCompanyStaffs(CompanyStaff companyStaff) {
        try {
            companyStaffRepository.save(companyStaff);
            return ResponseEntity.ok("Saved successfully");
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while saving details: " + exception.getMessage());
        }
    }
        public CompanyStaff updateCompanyStaffs (Long id, CompanyStaff companyStaffDetails){
            CompanyStaff companyStaff = getCompanyStaffsById(id);
            companyStaff.setName(companyStaffDetails.getName());
            companyStaff.setRoles(companyStaffDetails.getRoles());
            companyStaff.setCleaningCompany(companyStaffDetails.getCleaningCompany());
            return companyStaffRepository.save(companyStaff);
        }

        public ResponseEntity<?> deleteCompanyStaffs (Long id){
            try {
                // Check if Company exists
                if (!companyStaffRepository.existsById(id)) {
                    return ResponseEntity
                            .status(HttpStatus.NOT_FOUND)
                            .body("CompanyStaff with ID " + id + " not found.");
                }
                // Delete CompanyStaff
                companyStaffRepository.deleteById(id);
                // Return success message
                return ResponseEntity
                        .ok()
                        .body("CompanyStaff with ID " + id + " has been successfully deleted.");
            } catch (Exception deleteException) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete CompanyStaff with ID " + id);
            }
        }

    public long countCompanyStaffs() {
        return companyStaffRepository.count();
    }

//    public List<CompanyStaff> getCompanyStaffsByRole(StaffRoles staffRoles) {
//        return companyStaffRepository.findByRole(staffRoles);
//    }
}
