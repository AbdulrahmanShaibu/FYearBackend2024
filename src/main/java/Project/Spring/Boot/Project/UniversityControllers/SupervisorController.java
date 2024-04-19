package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Supervisor;
import Project.Spring.Boot.Project.UniversityServices.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class SupervisorController {
    @Autowired
    private SupervisorService supervisorService;

    @GetMapping("/list/supervisors")
    public List<Supervisor> getAllSupervisors() {
        return supervisorService.getAllSupervisors();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Supervisor> getSupervisorById(@PathVariable(value = "id") Long id) {
        Supervisor supervisor = supervisorService.getSupervisorById(id);
        return ResponseEntity.ok().body(supervisor);
    }

    @PostMapping("/post/supervisors")
    public ResponseEntity<ResponseEntity<String>> createSupervisor(@RequestBody Supervisor supervisor) {
        ResponseEntity<String> createdSupervisor = supervisorService.createSupervisor(supervisor);
        return
                ResponseEntity.status(HttpStatus.CREATED).body(createdSupervisor);
    }

    @PutMapping("/update/supervisors/{id}")
    public ResponseEntity<Supervisor> updateSupervisor(@PathVariable(value = "id") Long id,
                     @RequestBody Supervisor supervisorDetails) {
        Supervisor updatedSupervisor = supervisorService.updateSupervisor(id, supervisorDetails);
        return ResponseEntity.ok().body(updatedSupervisor);
    }

    @DeleteMapping("/delete/supervisors/{id}")
    public ResponseEntity<?> deleteSupervisor(@PathVariable(value = "id") Long id) {
        try {
            return supervisorService.deleteSupervisor(id);
        } catch (Exception deleteException) {
           return   ResponseEntity
                   .status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error while deleting supervisor" + deleteException.getMessage());
        }
    }
}
