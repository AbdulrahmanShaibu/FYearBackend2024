package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Staff;
import Project.Spring.Boot.Project.UniversityServices.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/post/staff")
    public Staff createStaff(@RequestBody Staff staff){
        Staff createdStaff = staffService.createStaff(staff);
        return createdStaff;
    }

    @GetMapping("/list/staff")
    public List<Staff>staffList(){
        return staffService.staffList();
    }

    @GetMapping("/count/staff")
    public long countStaff(){
        return staffService.countStaff();
    }

    @GetMapping("/get/staff/{id}")
    public Optional<Staff> findStaffById(@PathVariable(value = "id") int id){
        return staffService.findStaffById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") int id) {
        Optional<Staff> optionalStaff = findStaffById(id);
        if (optionalStaff.isPresent()) {
            staffService.deleteStaff(optionalStaff.get());
            return ResponseEntity.ok("Staff with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/staff/{id}")
    public ResponseEntity<?> updateStaff(@PathVariable(value = "id") int id, @RequestBody Staff staff) {
        try {
            Staff updatedStaff = staffService.updateStaff(id, staff);
            return ResponseEntity.ok(updatedStaff);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

   @GetMapping("/staffs/count")
    public long staffClaims(){
        return staffService.staffClaims();
   }

//    @GetMapping("/get/name")
//    public Staff getByStaffName(@RequestParam String StaffName){
//        return staffService.getByStaffName(StaffName);
//    }

}
