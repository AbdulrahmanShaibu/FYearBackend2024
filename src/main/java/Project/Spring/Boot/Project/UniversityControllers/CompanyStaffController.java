package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.CompanyStaff;
import Project.Spring.Boot.Project.University.Models.Roles.StaffRoles;
import Project.Spring.Boot.Project.University.Models.Roles.RoleTypeRepository;
import Project.Spring.Boot.Project.UniversityRepository.CleaningCompanyRepository;
import Project.Spring.Boot.Project.UniversityRepository.CompanyStaffRepository;
import Project.Spring.Boot.Project.UniversityServices.CompanyStaffService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class CompanyStaffController {
    @Autowired
    private CompanyStaffService companyStaffService;

    @Autowired
    CleaningCompanyRepository cleaningCompanyRepository;

    @Autowired
    CompanyStaffRepository companyStaffRepository;

    @Autowired
    RoleTypeRepository roleTypeRepository;

    private static final Logger logger = LoggerFactory.getLogger(CompanyStaffController.class);

    @GetMapping("/list/company-staffs")
    public ResponseEntity<List<CompanyStaff>> getAllCompanyStaffs() {
        return ResponseEntity.ok(companyStaffService.getAllCompanyStaffs());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CompanyStaff> getCompanyStaffsById(@PathVariable Long id) {
        CompanyStaff companyStaff = companyStaffService.getCompanyStaffsById(id);
        return ResponseEntity.ok(companyStaff);
    }

    @PostMapping("/post/company-staff")
    @Transactional
    public ResponseEntity<String> createCompanyStaffs(@Valid @RequestBody CompanyStaff companyStaff) {
        try {
            // Validate roles
            List<StaffRoles> roles = companyStaff.getRoles();
            for (StaffRoles role : roles) {
                roleTypeRepository.findByRoleName(role.getRoleName())
                        .orElseThrow(() -> new BadRequestException("Role with name " + role.getRoleName() + " does not exist."));
            }

            // Validate cleaning company
            cleaningCompanyRepository.findById(companyStaff.getCleaningCompany().getCompanyId())
                    .orElseThrow(() -> new BadRequestException("Cleaning company with ID " + companyStaff.getCleaningCompany().getCompanyId() + " does not exist."));

            // Save the company staff
            companyStaffRepository.save(companyStaff);
            return ResponseEntity.status(HttpStatus.CREATED).body("Saved successfully");

        } catch (BadRequestException e) {
            logger.error("Bad request: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Error while saving details: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while saving details: " + e.getMessage());
        }
    }


    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @PutMapping("/update/company-staff/{id}")
    public ResponseEntity<CompanyStaff> updateCompanyStaffs(@PathVariable Long id, @RequestBody CompanyStaff companyStaffDetails) {
        return ResponseEntity.ok(companyStaffService.updateCompanyStaffs(id, companyStaffDetails));
    }

    @DeleteMapping("/delete/company-staff/{id}")
    public ResponseEntity<String> deleteCompanyStaffs(@PathVariable Long id) {
        return companyStaffService.deleteCompanyStaffs(id);
    }

    @GetMapping("/count/company-staff")
    public ResponseEntity<Long> countCompanyStaffs() {
        return ResponseEntity.ok(companyStaffService.countCompanyStaffs());
    }
}
