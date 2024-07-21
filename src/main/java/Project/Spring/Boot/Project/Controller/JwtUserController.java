package Project.Spring.Boot.Project.Controller;

import Project.Spring.Boot.Project.Repository.JwtRepository;
import Project.Spring.Boot.Project.SecurityServices.JwtUserService;
import Project.Spring.Boot.Project.Model.JwtUser;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// JwtUserController.java
@RestController
@RequestMapping("/api/v1")
public class JwtUserController {

    @Autowired
    public JwtRepository jwtRepository;
    private final JwtUserService userService;

    @Autowired
    public JwtUserController(JwtUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody JwtUser user) {
        JwtUser savedUser = userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @GetMapping("/all-jwt-users")
    public List<JwtUser>geAllJwtUsersKnownAsStaffs(){
        return jwtRepository.findAll();
    }

    @GetMapping("/count/staff")
    public long countStaff() {
        return jwtRepository.count();
    }

    @GetMapping("/get/staff/{id}")
    public Optional<JwtUser> findStaffById(int id) {
        return Optional.ofNullable(jwtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id " + id)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStaff(JwtUser staffs) {
        jwtRepository.delete(staffs);
    }

    @PutMapping("/update/staff/{id}")
    public JwtUser updateStaff(int id, JwtUser staffs) {
        Optional<JwtUser> optionalStaff = findStaffById(id);
        if (optionalStaff.isPresent()) {
            JwtUser existingStaffs = optionalStaff.get();
            existingStaffs.setFirstName(staffs.getFirstName());
            existingStaffs.setLastName(staffs.getLastName());
            existingStaffs.setEmail(staffs.getEmail());
            existingStaffs.setPassword(staffs.getPassword()); // to checked
            existingStaffs.setStaffComplaints(staffs.getStaffComplaints());
            existingStaffs.setAttachments(staffs.getAttachments());
            // set other attributes if needed
            return jwtRepository.save(existingStaffs);
        } else {
            throw new RuntimeException("Staff not updated with id: " + id);
        }
    }

    @GetMapping("/staffs/count")
    public long staffClaims() {
        return jwtRepository.count();
    }

}

