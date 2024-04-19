package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Department;
import Project.Spring.Boot.Project.UniversityServices.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private  DepartmentService departmentService;

    @PostMapping("/post/department")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping("/list/department")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/count/department")
    public long countDepartments(){
        return departmentService.countDepartments();
    }

    @DeleteMapping("/delete/department/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) {
        boolean deleted = departmentService.deleteDepartment(departmentId);
        if (deleted) {
            return ResponseEntity.ok("Department deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/department/{departmentId}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long departmentId, @RequestBody Department department) {
        try {
            Department updated = departmentService.updateDepartment(departmentId, department);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update department: " + e.getMessage());
        }
    }
}
