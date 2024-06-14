package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.StaffComplain;
import Project.Spring.Boot.Project.UniversityServices.StaffComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class StaffComplainController {

    @Autowired
    private StaffComplainService staffComplainService;

    @PostMapping("/save/StaffComplain")
    public StaffComplain saveStaffComplain(@RequestBody StaffComplain staffComplain){
        return staffComplainService.saveStaffComplain(staffComplain);
    }

    @GetMapping("/list/StaffComplain")
    public List<StaffComplain>StaffComplainList(){
        return staffComplainService.StaffComplainList();
    }

    @GetMapping("/get/StaffComplain/{id}")
    public Optional<StaffComplain> findStaffComplainById(@PathVariable(value = "id") int id){
        return staffComplainService.findStaffComplainById(id);
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
