//package Project.Spring.Boot.Project.UniversityControllers;
//
//import Project.Spring.Boot.Project.University.Models.Staffs;
//import Project.Spring.Boot.Project.UniversityServices.StaffsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/api/v1")
//public class StaffsController {
//
//    @Autowired
//    private StaffsService staffsService;
//
////    @PostMapping("/post/staff")
////    public Staffs createStaff(@RequestBody Staffs staffs){
////        Staffs createdStaffs = staffsService.createStaff(staffs);
////        return createdStaffs;
////    }
////
////    @GetMapping("/staffs/list")
////    public List<Staffs>staffList(){
////        return staffsService.staffList();
////    }
////
////    @GetMapping("/count/staff")
////    public long countStaff(){
////        return staffsService.countStaff();
////    }
////
////    @GetMapping("/get/staff/{id}")
////    public Optional<Staffs> findStaffById(@PathVariable(value = "id") int id){
////        return staffsService.findStaffById(id);
////    }
////
////    @DeleteMapping("/delete/{id}")
////    public ResponseEntity<String> deleteStaff(@PathVariable("id") int id) {
////        Optional<Staffs> optionalStaff = findStaffById(id);
////        if (optionalStaff.isPresent()) {
////            staffsService.deleteStaff(optionalStaff.get());
////            return ResponseEntity.ok("Staff with ID " + id + " deleted successfully.");
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @PutMapping("/update/staff/{id}")
////    public ResponseEntity<?> updateStaff(@PathVariable(value = "id") int id, @RequestBody Staffs staffs) {
////        try {
////            Staffs updatedStaffs = staffsService.updateStaff(id, staffs);
////            return ResponseEntity.ok(updatedStaffs);
////        } catch (RuntimeException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
////        }
////    }
////
////   @GetMapping("/staffs/count")
////    public long staffClaims(){
////        return staffsService.staffClaims();
////   }
//
////    @GetMapping("/get/name")
////    public Staff getByStaffName(@RequestParam String StaffName){
////        return staffService.getByStaffName(StaffName);
////    }
//
//}
