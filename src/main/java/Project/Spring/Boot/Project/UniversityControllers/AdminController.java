package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Admin;
import Project.Spring.Boot.Project.UniversityRepository.AdminRepository;
import Project.Spring.Boot.Project.UniversityServices.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/post/admin")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

}
