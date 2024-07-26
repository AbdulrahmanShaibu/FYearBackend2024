package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.Model.JwtUser;
import Project.Spring.Boot.Project.Repository.JwtRepository;
import Project.Spring.Boot.Project.SecurityServices.JwtUserServiceImpl;
import Project.Spring.Boot.Project.University.Models.StaffComplain;
import Project.Spring.Boot.Project.UniversityServices.StaffComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class StaffComplainController {

    @Autowired
    private StaffComplainService staffComplainService;

    @Autowired
    private JwtRepository jwtRepository;

    @Autowired
    private JwtUserServiceImpl jwtUserService;

    // send complain by email
//    http://localhost:8080/api/v1/save/staff-complain?email=kheria048@gmail.com
    @PostMapping("/save/staff-complain")
    public StaffComplain createComplain(@RequestParam String email, @RequestBody StaffComplain staffComplain) {
        System.out.println("Received email: " + email); // Add this line for debugging
        System.out.println("Received complaint: " + staffComplain);
        JwtUser user = jwtUserService.getUserByEmail(email);
        if (user != null) {
            staffComplain.setStaffs(user);
            return staffComplainService.saveStaffComplain(staffComplain);
        } else {
            throw new IllegalArgumentException("Invalid email: User not found");
        }
    }

    @GetMapping("/get/staff-details")
    public JwtUser getStaffDetails(@RequestParam String email) {
        JwtUser user = jwtUserService.getUserByEmail(email);
        if (user != null) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid email: User not found");
        }
    }


    @PostMapping("/save/StaffComplain")
    public StaffComplain createComplain(@RequestBody StaffComplain staffComplain, @AuthenticationPrincipal JwtUser user) {
        staffComplain.setStaffs(user);
        return staffComplainService.saveStaffComplain(staffComplain);
    }

    @GetMapping("/list/StaffComplain")
    public List<StaffComplain>StaffComplainList(){
        return staffComplainService.StaffComplainList();
    }

    @GetMapping("/complain/{id}")
    public ResponseEntity<StaffComplain> getComplaintById(@PathVariable int id) {
        Optional<StaffComplain> staffComplain = staffComplainService.getComplaintById(id);
        return staffComplain.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/StaffComplain/{id}")
    public StaffComplain updateStaffComplain(@PathVariable(value = "id") int id, @RequestBody StaffComplain newStaffComplain){
        return staffComplainService.updateStaffComplain(id, newStaffComplain);
    }

    @DeleteMapping("/delete/StaffComplain/{id}")
    public void deleteStaffComplain(@PathVariable(value = "id") int id){
        staffComplainService.deleteStaffComplain(id);
    }

    @GetMapping("/count/StaffComplain")
    public long countStaffComplain(){
        return staffComplainService.countStaffComplain();
    }
}
