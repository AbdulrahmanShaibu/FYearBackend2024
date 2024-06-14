package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.CleaningCompany;
import Project.Spring.Boot.Project.UniversityServices.CleaningCompanyCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class CleaningCompanyController {

    @Autowired
    private CleaningCompanyCompanyService cleaningCompanyCompanyService;

    @GetMapping("/list")
    public List<CleaningCompany> getAllCompanies() {
        return cleaningCompanyCompanyService.getAllCompanies();
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<CleaningCompany> getCompanyById(@PathVariable int id) {
        Optional<CleaningCompany> company = cleaningCompanyCompanyService.getCompanyById(id);
        if (company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post/company")
    public CleaningCompany createCompany(@RequestBody CleaningCompany cleaningCompany) {
        // Ensure all staff members are associated with the company
//        if (company.getStaffs() != null) {
//            for (Staff staff : company.getStaffs()) {
//                staff.setCompany(company);
//            }
//        }
        return cleaningCompanyCompanyService.saveCompany(cleaningCompany);
    }

    @PutMapping("/update/company/{id}")
    public ResponseEntity<CleaningCompany> updateCompany(@PathVariable int id, @RequestBody CleaningCompany cleaningCompanyDetails) {
        Optional<CleaningCompany> company = cleaningCompanyCompanyService.getCompanyById(id);
        if (company.isPresent()) {
            CleaningCompany existingCleaningCompany = company.get();
            existingCleaningCompany.setCompanyName(cleaningCompanyDetails.getCompanyName());
            existingCleaningCompany.setAddress(cleaningCompanyDetails.getAddress());
            existingCleaningCompany.setCompanyStaffs(cleaningCompanyDetails.getCompanyStaffs());
            final CleaningCompany updatedCleaningCompany = cleaningCompanyCompanyService.updateCompany(existingCleaningCompany);
            return ResponseEntity.ok(updatedCleaningCompany);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/company/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable int id) {
        Optional<CleaningCompany> company = cleaningCompanyCompanyService.getCompanyById(id);
        if (company.isPresent()) {
            cleaningCompanyCompanyService.deleteCompany(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
