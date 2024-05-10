package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Cleaner;
import Project.Spring.Boot.Project.UniversityServices.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class CleanerController {

    @Autowired
    private CleanerService cleanerService;

    @PostMapping("/save/cleaner")
    public Cleaner createCleaner(@RequestBody Cleaner cleaner){
        return cleanerService.createCleaner(cleaner);
    }

    @GetMapping("/list/cleaner")
    public List<Cleaner> cleanerList(){
        return cleanerService.cleanerList();
    }

    @GetMapping("/find/{id}")
    public Optional<Cleaner> getCleanerById(@PathVariable(value = "id") int id){
        return cleanerService.getCleanerById(id);
    }

    @DeleteMapping("/delete/cleaner/{id}")
    public void deleteCleaner(@PathVariable(value = "id") int id){
        cleanerService.deleteCleaner(id);
    }

    @PutMapping("/update/cleaner/{id}")
    public Cleaner UpdateCleaner(@PathVariable(value = "id") int id, @RequestBody Cleaner newCleanerDetails){
        return cleanerService.updateCleaner(id,newCleanerDetails);
    }

    @GetMapping("/count/cleaners")
    public long countCleaners(){
        return cleanerService.countCleaners();
    }

}
