package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.CompanyStaff;
import Project.Spring.Boot.Project.UniversityServices.CompanyStaffService;
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

    @GetMapping("/list/company-staffs")
    public List<CompanyStaff> getAllCompanyStaffs() {
        return companyStaffService.getAllCompanyStaffs();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CompanyStaff> getCompanyStaffsById(@PathVariable(value = "id") Long id) {
        CompanyStaff companyStaff = companyStaffService.getCompanyStaffsById(id);
        return ResponseEntity.ok().body(companyStaff);
    }

    @PostMapping("/post/company-staff")
    public ResponseEntity<ResponseEntity<String>> createCompanyStaffs(@RequestBody CompanyStaff companyStaff) {
        ResponseEntity<String> createdCompanyStaff = companyStaffService.createCompanyStaffs(companyStaff);
        return
                ResponseEntity.status(HttpStatus.CREATED).body(createdCompanyStaff);
    }

    @PutMapping("/update/company-staff/{id}")
    public ResponseEntity<CompanyStaff> updateCompanyStaffs(@PathVariable(value = "id") Long id,
                                                         @RequestBody CompanyStaff companyStaffDetails) {
        CompanyStaff updatedCompanyStaff = companyStaffService.updateCompanyStaffs(id, companyStaffDetails);
        return ResponseEntity.ok().body(updatedCompanyStaff);
    }

    @DeleteMapping("/delete/company-staff/{id}")
    public ResponseEntity<?> deleteCompanyStaffs(@PathVariable(value = "id") Long id) {
        try {
            return companyStaffService.deleteCompanyStaffs(id);
        } catch (Exception deleteException) {
           return   ResponseEntity
                   .status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error while deleting company staff" + deleteException.getMessage());
        }
    }

    @GetMapping("/count/company-staff")
    public long countCompanyStaffs(){
        return companyStaffService.countCompanyStaffs();
    }

//    @GetMapping("/role/{role}")
//    public List<CompanyStaff> getCompanyStaffsByRole(@PathVariable StaffRoles staffRoles) {
//        return companyStaffService.getCompanyStaffsByRole(staffRoles);
//    }
}
