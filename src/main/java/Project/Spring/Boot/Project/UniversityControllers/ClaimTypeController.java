package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.ClaimType;
import Project.Spring.Boot.Project.UniversityServices.ClaimTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class ClaimTypeController {
    @Autowired
    private ClaimTypeService service;

    @GetMapping("list/claim-type")
    public List<ClaimType> findAll() {
        return service.findAll();
    }

    @GetMapping("get/client-cleaners/{id}")
    public ClaimType findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ClaimType save(@RequestBody ClaimType claimType) {
        return service.save(claimType);
    }

    @PutMapping("update/list/claim-type/{id}")
    public ClaimType update(@PathVariable Long id, @RequestBody ClaimType claimType) {
        claimType.setId(id);
        return service.save(claimType);
    }

    @DeleteMapping("delete/list/claim-type/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
