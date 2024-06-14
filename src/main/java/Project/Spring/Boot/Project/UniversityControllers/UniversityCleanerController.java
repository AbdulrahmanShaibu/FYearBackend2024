//package Project.Spring.Boot.Project.UniversityControllers;
//
//import Project.Spring.Boot.Project.University.Models.UniversityCleaner;
//import Project.Spring.Boot.Project.UniversityServices.UniversityCleanerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/api/v1")
//public class UniversityCleanerController {
//
//    @Autowired
//    private UniversityCleanerService universityCleanerService;
//
//    @PostMapping("/save/cleaner")
//    public UniversityCleaner createCleaner(@RequestBody UniversityCleaner universityCleaner){
//        return universityCleanerService.createCleaner(universityCleaner);
//    }
//
//    @GetMapping("/list/cleaner")
//    public List<UniversityCleaner> cleanerList(){
//        return universityCleanerService.cleanerList();
//    }
//
//    @GetMapping("/find/{id}")
//    public Optional<UniversityCleaner> getCleanerById(@PathVariable(value = "id") int id){
//        return universityCleanerService.getCleanerById(id);
//    }
//
//    @DeleteMapping("/delete/cleaner/{id}")
//    public void deleteCleaner(@PathVariable(value = "id") int id){
//        universityCleanerService.deleteCleaner(id);
//    }
//
//    @PutMapping("/update/cleaner/{id}")
//    public UniversityCleaner UpdateCleaner(@PathVariable(value = "id") int id, @RequestBody UniversityCleaner newUniversityCleanerDetails){
//        return universityCleanerService.updateCleaner(id, newUniversityCleanerDetails);
//    }
//
//    @GetMapping("/count/cleaners")
//    public long countCleaners(){
//        return universityCleanerService.countCleaners();
//    }
//
//}
